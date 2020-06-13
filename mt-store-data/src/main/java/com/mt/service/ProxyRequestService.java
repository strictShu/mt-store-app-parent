package com.mt.service;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
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

}
