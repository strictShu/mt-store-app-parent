package com.mt.service;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;
import java.util.Map;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/13
 */

@Service
public class ProxyRequestService {

    @Value("#{ @environment['proxy.url'] ?: 'https://api.xiaoxiangdaili.com/ip/get?' }")
    private String proxyUrl;
    @Value("#{ @environment['proxy.appKey'] ?: '589004976408645632' }")
    private String appKey;
    @Value("#{ @environment['proxy.appSecret'] ?: '4bHzbHoO' }")
    private String appSecret;


    public Map getProxy() {
    //https://api.xiaoxiangdaili.com/ip/get?appKey=589004976408645632&appSecret=4bHzbHoO
        String url = proxyUrl + "appKey=" + appKey + "&appSecret=" + appSecret;
        try {
            Document document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .userAgent(url)
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
    private final static String ProxyUser = "应用id（后台-产品管理-隧道代理页面可查）";
    private final static String ProxyPass = "应用密码（后台-产品管理-隧道代理页面可查）";

    // 代理服务器
    private final static String ProxyHost = "http-dynamic.xiaoxiangdaili.com";
    private final static Integer ProxyPort = 10030;


    /**
     * 隧道代理
     * @param url
     * @return
     */
    public Document  getUrlProxyContent(String url) {

        // JDK 8u111版本后，目标页面为HTTPS协议，启用proxy用户密码鉴权
        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");

        Authenticator.setDefault(new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ProxyUser, ProxyPass.toCharArray());
            }
        });

        System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ProxyHost, ProxyPort));

        try {
            Document doc = Jsoup.connect(url)
                    .timeout(3000)
                    .proxy(proxy)
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
