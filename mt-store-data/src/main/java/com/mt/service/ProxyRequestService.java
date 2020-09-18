package com.mt.service;

import com.alibaba.fastjson.JSON;
import com.mt.service.impl.MeiTuanStoreDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/13
 */

@Service
@Slf4j
public class ProxyRequestService {

    @Value("#{ @environment['proxy.url'] ?: 'https://api.xiaoxiangdaili.com/ip/get?' }")
    private String proxyUrl;
    @Value("#{ @environment['proxy.appKey'] ?: '589004976408645632' }")
    private String appKey;
    @Value("#{ @environment['proxy.appSecret'] ?: '4bHzbHoO' }")
    private String appSecret;

    @Autowired
    private MeiTuanStoreDataServiceImpl meiTuanStoreDataService;


    public Map getProxy() {
        //https://api.xiaoxiangdaili.com/ip/get?appKey=589004976408645632&appSecret=4bHzbHoO
        String url = proxyUrl + "appKey=" + appKey + "&appSecret=" + appSecret;
        try {
            Document document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    //.userAgent(url)
                    .get();

            String json = document.text();
            Map map = JSON.parseObject(json, Map.class);
            List<Map> data = (List<Map>) map.get("data");
            Map proxyMap = data.get(0);
            System.out.println(proxyUrl);
            return proxyMap;
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }


    // 代理隧道验证信息
    @Value("#{ @environment['proxy.proxyUser'] ?: 't19274254688819' }")
    private String proxyUser;
    @Value("#{ @environment['proxy.proxyPassword'] ?: 'a80wjf7o' }")
    private String proxyPassword;

    // 代理服务器
    private final static String ProxyHost = "tps118.kdlapi.com";
    private final static Integer ProxyPort = 15818;

    @PostConstruct
    public void initTheBean() {

        System.setProperty("https.proxyUser", proxyUser);
        System.setProperty("https.proxyPassword", proxyPassword);
        System.setProperty("http.proxyUser", proxyUser);
        System.setProperty("http.proxyPassword", proxyPassword);
    }


    /**
     * 隧道代理
     *
     * @param url
     * @return
     */
    public Document getUrlProxyContent(String url) {
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        Authenticator.setDefault(new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
            }
        });
        String userAgent = meiTuanStoreDataService.ua[new Random().nextInt(meiTuanStoreDataService.ua.length)];
        log.info("代理使用的ua: {}", userAgent);
        try {
            Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(10 * 1000)
                    .proxy(ProxyHost, ProxyPort)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header("Accept-Encoding", "identity")
                    .header("Host", "apimobile.meituan.com")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Sec-Fetch-Dest", "document")
                    .header("Sec-Fetch-Mode", "navigate")
                    .header("Sec-Fetch-Site", "none")
                    //.cookie("ci", "96")
                    .userAgent(userAgent)
                    .get();

            if (doc != null) {
                return doc;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String proxyUser_T = "t19274254688819";
    private String proxyPassword_T = "a80wjf7o";

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1 * 1000);
            ProxyRequestService proxyRequestService = new ProxyRequestService();
           // proxyRequestService.initTheBean();
            System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
            String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=b125d52020a94acd8b5c.1591507012.1.0.0&userid=-1&limit=64&offset=" + i + "&areaId=139&q=%25E9%2585%2592%25E5%25BA%2597&Referer=https://jn.meituan.com/%25E9%2585%2592%25E5%25BA%2597";
            Document urlProxyContent = proxyRequestService.test(url);
            String text = urlProxyContent.text();
            System.out.println(text);
        }

    }

    public Document test(String url) {
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        Authenticator.setDefault(new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUser_T, proxyPassword_T.toCharArray());
            }
        });
        MeiTuanStoreDataServiceImpl meiTuanStoreDataService = new MeiTuanStoreDataServiceImpl();
        String userAgent = meiTuanStoreDataService.ua[new Random().nextInt(meiTuanStoreDataService.ua.length)];
        log.info("代理使用的ua: {}", userAgent);
        try {
            Document doc = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .timeout(10 * 1000)
                    .proxy(ProxyHost, ProxyPort)
                    .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header("Accept-Encoding", "identity")
                    .header("Host", "apimobile.meituan.com")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header("Sec-Fetch-Dest", "document")
                    .header("Sec-Fetch-Mode", "navigate")
                    .header("Sec-Fetch-Site", "none")
                    .cookie("ci", "96")
                    .userAgent(userAgent)
                    .get();

            if (doc != null) {
                return doc;
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
