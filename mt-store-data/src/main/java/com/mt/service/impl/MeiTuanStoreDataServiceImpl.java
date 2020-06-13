package com.mt.service.impl;

import com.alibaba.fastjson.JSON;
import com.mt.entity.MeiTuanData;
import com.mt.entity.Store;
import com.mt.service.AbstractHandlerStore;
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

    @Value("${cityId}")
    private String cityId;

    @Value("${refererUrl}")
    private String refererUrl;

    @Autowired
    private StoreDaoService storeDaoService;

    Map<String, String> cookies = new HashMap<>();

    Map<String, String> headers = new HashMap<>();

    List<String> keyword = Arrays.asList("美食", "烧烤","海鲜","外卖","家常菜","自助餐","小吃","蛋糕","水果","奶茶","火锅","面馆",
            "酒店","民宿","宾馆","洗浴","足疗","按摩","保健",
            "酒吧","采摘","网吧","宠物","健身","轰趴","美容","美发","摄影","儿童摄影");
    @PostConstruct
    public void initHeader() {
        cookies.put("_lxsdk_cuid", "1725634e713c8-06b5676eb40129-1333062-2a3000-1725634e7138");
        cookies.put("Hm_lvt_f66b37722f586a240d4621318a5a6ebe", "1591283315");
        cookies.put("_hc.v", "e1b8d7bb-a846-a185-83a4-bbeeb57d54da.1591283422");
        cookies.put("iuuid", "14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0");
        cookies.put("_lxsdk", "14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0");
        cookies.put("webp", "1");
        cookies.put("__utma", "74597006.727697914.1591515447.1591515447.1591515447.1");
        cookies.put("__utmz", "=74597006.1591515447.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
        cookies.put("cityname", "%E6%B5%8E%E5%8D%97");
        cookies.put("latlng", "35.074806,118.320453,1591517019808");
        cookies.put("i_extend", "C_b1Gimthomepagecategory1394H__a");
        cookies.put("wm_order_channel", "mtib");
        cookies.put("utm_source", "60030");
        cookies.put("service-off", "0");
        cookies.put("_lx_utm", "utm_source%3D60030");
        cookies.put("ci", "96");
        cookies.put("rvct", "96%2C727%2C1156%2C1157%2C465%2C30");

        headers.put("Host", "apimobile.meituan.com");
        headers.put("Upgrade-Insecure-Requests", "1");

    }


    @Override
    public void getStoreData(String keyword) {
        String jsonResult = wrapParameters(keyword, 64, 0,null);
        log.info(jsonResult);
        handlerData(jsonResult, keyword);
    }

    private void handlerData(String jsonResult, String keyword) {
        if (StringUtils.isNotBlank(jsonResult) && jsonResult.contains("验证")) {
            log.error("需要更换ip");
            return;
        }
        MeiTuanData meiTuanData = JSON.parseObject(jsonResult, MeiTuanData.class);
        List<MeiTuanData.DataEntity.SearchResultEntity> searchResult = meiTuanData.getData().getSearchResult();
        searchResult.forEach(
                searchResultEntity -> uploadData(searchResultEntity, keyword)
        );
    }

    private void uploadData(MeiTuanData.DataEntity.SearchResultEntity searchResultEntity, String kerword) {
        Date date = new Date();
        Store store = Store.builder()
                .id(searchResultEntity.getId() + "")
                .title(searchResultEntity.getTitle())
                .phone(searchResultEntity.getPhone())
                .city(cityId)
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
    public String wrapParameters(String keyword, int limit, int offset,String areaId) {
        String url = apiUrl + cityId + "?"
                + "uuid=" + uuid[new Random().nextInt(uuid.length)]
                + "&userid=-1&limit=" + limit
                + "&offset=" + offset
                + "&q=" + keyword
                + "&Referer=" + refererUrl
                + keyword
                +areaId==null?"":"&areaid="+areaId;
        log.info(url);
        String newA = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=cd1a9ca261144b33bc8c.1591507012.1.0.&userid=-1&limit=10&offset=0&q=烧烤&Referer=https://jn.meituan.com/烧烤";
        // String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=dab4577b0f964ebea181.1591278152.1.0.0&userid=-1&limit=64&offset=0&q=美食&Referer=https://jn.meituan.com/美食";
        Document document = doHttp(url);
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
                    // .proxy(null)
                    .userAgent(userAgent)
                    .cookies(cookies)
                    .headers(headers)
                    .get();
        } catch (IOException e) {
            log.error("获取数据失败", e);
            return null;
        }
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
        cookies.put("_lxsdk_cuid", "1725634e713c8-06b5676eb40129-1333062-2a3000-1725634e7138");
        cookies.put("Hm_lvt_f66b37722f586a240d4621318a5a6ebe", "1591283315");
        cookies.put("_hc.v", "e1b8d7bb-a846-a185-83a4-bbeeb57d54da.1591283422");
        cookies.put("iuuid", "14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0");
        cookies.put("_lxsdk", "14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0");
        cookies.put("webp", "1");
        cookies.put("__utma", "74597006.727697914.1591515447.1591515447.1591515447.1");
        cookies.put("__utmz", "=74597006.1591515447.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
        cookies.put("cityname", "%E6%B5%8E%E5%8D%97");
        cookies.put("latlng", "35.074806,118.320453,1591517019808");
        cookies.put("i_extend", "C_b1Gimthomepagecategory1394H__a");
        cookies.put("wm_order_channel", "mtib");
        cookies.put("utm_source", "60030");
        cookies.put("service-off", "0");
        cookies.put("_lx_utm", "utm_source%3D60030");
        cookies.put("ci", "96");
        cookies.put("rvct", "96%2C727%2C1156%2C1157%2C465%2C30");

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Host", "apimobile.meituan.com");
        headers.put("Upgrade-Insecure-Requests", "1");
        MeiTuanStoreDataServiceImpl meiTuanStoreDataService = new MeiTuanStoreDataServiceImpl();
        String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=b125d52020a94acd8b5c.1591507012.1.0.0&userid=-1&limit=64&offset=1&areaId=139&q=%25E9%2585%2592%25E5%25BA%2597&Referer=https://jn.meituan.com/%25E9%2585%2592%25E5%25BA%2597";
        String userAgent = meiTuanStoreDataService.ua[new Random().nextInt(meiTuanStoreDataService.ua.length)];
        System.out.println(userAgent);
        for (int i = 0; i < 10; i++) {
            try {
                Document document = Jsoup.connect(url)
                        .ignoreContentType(true)
                        //           .proxy("223.199.23.159",9999)
                        // .headers(headers)
                        .cookies(cookies)
                        .userAgent(userAgent)
                        // .cookies()
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
