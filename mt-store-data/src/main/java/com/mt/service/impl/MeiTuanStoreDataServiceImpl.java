package com.mt.service.impl;

import com.alibaba.fastjson.JSON;
import com.mt.entity.Area;
import com.mt.entity.MeiTuanData;
import com.mt.entity.Store;
import com.mt.service.AbstractHandlerStore;
import com.mt.service.ProxyRequestService;
import com.mt.service.StoreDaoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/7
 */
@Service
@Slf4j
public class MeiTuanStoreDataServiceImpl extends AbstractHandlerStore {


    @Value("${apiUrl}")
    private String apiUrl;

//    @Value("${cityId}")
//    private String cityId;

//    @Value("${refererUrl}")
//    private String refererUrl;

    @Autowired
    private StoreDaoService storeDaoService;

    @Autowired
    private ProxyRequestService proxyRequestService;

    public Map proxy;


    @PostConstruct
    public void init() {
        initHeader();
    }


    @Override
    public void getStoreData(String keyword) {
        String jsonResult = wrapParameters(keyword, 64, 0, null);
        log.info(jsonResult);
        handlerData(jsonResult, keyword,"test");
    }

    @Override
    public void taskProcess(String keyword, int limit, int offset, Area area) {
        String jsonResult = wrapParameters(keyword, limit, offset, area);
        log.info("数据结果: {} ", jsonResult);
        boolean handleResult = handlerData(jsonResult, keyword,area.getCityName());
        if (!handleResult) {
            retryRequest(keyword, limit, offset, area);
        }
    }

    private void retryRequest(String keyword, int limit, int offset, Area area) {
        String refererUrl = "https://" + area.getCityAcronym() + ".meituan.com/";
        // todo 重试次数超载后需要记录ip到mysql
        for (int j = 0; j < 10; j++) {
            log.info("重试获取次数 : {}", j);
            String url = apiUrl + area.getCityId() + "?"
                    + "uuid=" + uuid[new Random().nextInt(uuid.length)]
                    + "&userid=-1&limit=" + limit
                    + "&offset=" + offset * limit
                    + "&q=" + keyword
                    + "&Referer=" + refererUrl
                    + keyword
                    + (area.getId() == null ? "" : "&areaId=" + area.getId());


//            if (proxy == null) {
//                //代理获取重试10次
//                for (int i = 0; i < 10; i++) {
//                    proxy = proxyRequestService.getProxy();
//                    if (proxy != null && ((String) proxy.get("ip")) != null) {
//                        break;
//                    } else {
//                        log.error("获取代理失败,次数 {}", i);
//                    }
//                }
//
//            }

            try {
                Document document = doHttpWithProxy(url);
                //Document document = proxyRequestService.getUrlProxyContent(url);
                String jsonResult = document.text();
                boolean handleResult = handlerData(jsonResult, keyword,area.getCityName());
                if (handleResult) {
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean handlerData(String jsonResult, String keyword,String cityName) {
        if (StringUtils.isNotBlank(jsonResult) && jsonResult.contains("验证") || StringUtils.isBlank(jsonResult)) {
            log.error("需要更换ip");
            return false;
        }
        MeiTuanData meiTuanData = JSON.parseObject(jsonResult, MeiTuanData.class);
        List<MeiTuanData.DataEntity.SearchResultEntity> searchResult = meiTuanData.getData().getSearchResult();
        searchResult.forEach(
                searchResultEntity -> uploadData(searchResultEntity, keyword,cityName)
        );

        return true;
    }

    private void uploadData(MeiTuanData.DataEntity.SearchResultEntity searchResultEntity, String kerword,String cityName) {
        Date date = new Date();
        Store store = Store.builder()
                .id(searchResultEntity.getId() + "")
                .title(searchResultEntity.getTitle())
                .phone(searchResultEntity.getPhone())
                .city(cityName)
                .address(searchResultEntity.getAddress())
                .areaname(searchResultEntity.getAreaname())
                .latitude(searchResultEntity.getLatitude())
                .longitude(searchResultEntity.getLongitude())
                .avgScore(searchResultEntity.getAvgscore())
                .avgPrice(searchResultEntity.getAvgprice())
                .comments(searchResultEntity.getComments())
                .backcatename(searchResultEntity.getBackCateName())
                .storeId(searchResultEntity.getId())
                .sourceKey(kerword)
                .sourceData(getServiceName())
                .creatTime(date)
                .updateTime(date)
                .build();
        storeDaoService.insertData(store);
    }

    /**
     * 组装参数
     *
     * @param keyword
     * @param limit
     * @return
     */
    public String wrapParameters(String keyword, int limit, int offset, Area area) {
        String refererUrl = "https://" + area.getCityAcronym() + ".meituan.com/";
        String url = apiUrl + area.getCityId() + "?"
                + "uuid=" + uuid[new Random().nextInt(uuid.length)]
                + "&userid=-1&limit=" + limit
                + "&offset=" + offset * limit
                + "&q=" + keyword
                + "&Referer=" + refererUrl
                + keyword
                + (area.getId() == null ? "" : "&areaId=" + area.getId());
        log.info(url);
        Document document = doHttp(url);
        if (document == null) {
            //本地异常 尝试代理
            return "验证";
        }

        String jsonResult = document.text();
        return jsonResult;
    }


    /**
     * 数据获取
     *
     * @param url
     * @return
     */
    private Document doHttp(String url) {
        String userAgent = ua[new Random().nextInt(ua.length)];
        log.info("UA: {}", userAgent);
        try {
            return Jsoup.connect(url)
                    .ignoreContentType(true)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header("Accept-Encoding", "identity")
                    .header("Host", "apimobile.meituan.com")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Sec-Fetch-Dest", "document")
                    .header("Sec-Fetch-Mode", "navigate")
                    .header("Sec-Fetch-Site", "none")
                    .userAgent(userAgent)
                    .cookies(cookies)
                    // .headers(headers)
                    .get();
        } catch (IOException e) {
            // log.error("获取数据失败", e);
            log.error("获取数据失败,需要代理");
            //return doHttp(url);
            return null;
        }
    }

    private Document doHttpWithProxy(String url) {

        // JDK 8u111版本后，目标页面为HTTPS协议，启用proxy用户密码鉴权


        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return proxyRequestService.getUrlProxyContent(url);
       /*
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");

        if (proxy == null) {
            proxy = proxyRequestService.getProxy();
        }
        String ip = (String) proxy.get("ip");
        Integer port = (Integer) proxy.get("port");
        String userAgent = ua[new Random().nextInt(ua.length)];
        log.info("UA: {}", userAgent);
        try {
            return Jsoup.connect(url)
                    .ignoreContentType(true)
                    .proxy(ip, port)
                    .userAgent(userAgent)
                    //  .cookies(cookies)
                    // .headers(headers)
                    .get();
        } catch (IOException e) {
            log.error("获取数据失败", e);
            return doHttpWithProxy(url);
        }*/
    }

    public static void main(String[] args) throws IOException {


//Cookie: _lxsdk_cuid=1725634e713c8-06b5676eb40129-1333062-2a3000-1725634e7138;
//        Hm_lvt_f66b37722f586a240d4621318a5a6ebe=1591283315;
//        _hc.v=e1b8d7bb-a846-a185-83a4-bbeeb57d54da.1591283422;
//        iuuid=14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0;
//        _lxsdk=14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0;
//        webp=1;
//        __utma=74597006.727697914.1591515447.1591515447.1591515447.1;
//        __utmz=74597006.1591515447.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none);
//        cityname=%E6%B5%8E%E5%8D%97;
//        latlng=35.074806,118.320453,1591517019808;
//        i_extend=C_b1Gimthomepagecategory1394H__a;
//        wm_order_channel=mtib;
//        utm_source=60030;
//        service-off=0;
//        _lx_utm=utm_source%3D60030;
//        ci=96;
//        rvct=96%2C727%2C1156%2C1157%2C465%2C30

        Map<String, String> cookies = new HashMap<>();
        // cookies.put("iuuid", "AE7EE5136792735A4355197D3109809A2827A977253525DA7E9370643E5213D6");
        // cookies.put("_hc.v", "5fbed49b-0126-b4c6-949f-d3bbbd493cdf.1590556422");
        // cookies.put("_lxsdk_cuid", "172548cf125c8-0f4244076da799-30647d01-1aeaa0-172548cf125c8");
        //cookies.put("_lxsdk", "AE7EE5136792735A4355197D3109809A2827A977253525DA7E9370643E5213D6");
        // cookies.put("cityname", " % E6 % B5 % 8E % E5 % 8D % 97");
        // cookies.put("webp", "1");
        // cookies.put("__utma", "74597006.1553331218 .1590641905 .1590641905 .1591515435 .2");
        // cookies.put("__utmz", "74597006.1591515435.2.2.utmcsr=blog.csdn.net|utmccn=(referral)|utmcmd=referral|utmcct=/xing851483876/article/details/81842329");
        // cookies.put("i_extend", "H__a100001__b2");
        cookies.put("ci", "96");

        Map<String, String> headers = new HashMap<String, String>();
        //  headers.put("Host", "apimobile.meituan.com");
        headers.put("Upgrade-Insecure-Requests", "1");
        MeiTuanStoreDataServiceImpl meiTuanStoreDataService = new MeiTuanStoreDataServiceImpl();
        String url = "http://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=cd1a9ca261144b33bc8c.1591507012.1.0.&userid=-1&limit=64&offset=2&q=%E9%85%92%E5%BA%97&Referer=https://jn.meituan.com/%E9%85%92%E5%BA%97&areaId=12466";
        String userAgent = meiTuanStoreDataService.ua[new Random().nextInt(meiTuanStoreDataService.ua.length)];
        System.out.println(userAgent);
        for (int i = 0; i < 10; i++) {
            try {
                Document document = Jsoup.connect(url)
                        .ignoreContentType(true)
                        //           .proxy("223.199.23.159",9999)
                        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                        .header("Accept-Encoding", "identity")
                        .header("Host", "apimobile.meituan.com")
                        .header("Upgrade-Insecure-Requests", "1")
                        .header("Sec-Fetch-Dest", "document")
                        .header("Sec-Fetch-Mode", "navigate")
                        .header("Sec-Fetch-Site", "none")
                        .cookies(cookies)
                        .userAgent(userAgent)
                        //.proxy("180.113.133.90", 35633)
                        .get();
                System.out.println(document.text());
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    @Override
    public String getServiceName() {
        return "美团";
    }


}
