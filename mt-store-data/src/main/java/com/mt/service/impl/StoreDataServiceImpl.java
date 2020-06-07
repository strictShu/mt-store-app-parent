package com.mt.service.impl;

import com.mt.service.StoreDataService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/7
 */
@Service
@Slf4j
public class StoreDataServiceImpl implements StoreDataService {

    @Value("${apiUrl}")
    private String apiUrl = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?";


    static String[] ua = {
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2486.0 Safari/537.36 Edge/13.10586",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.1651.1553.4686 Safari/537.35",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.5768.2612.9365 Safari/537.2",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.5144.464.1013 Safari/537.20",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.2283.6819.5131 Safari/537.23",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.577.1792.2095 Safari/537.28",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.3504.7354.6339 Safari/537.26",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.2202.988.3910 Safari/537.26",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/44.279.1528.6832 Safari/537.35",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.6306.5435.9131 Safari/537.23",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.2728.6567.6443 Safari/537.22",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.7712.6851.9281 Safari/537.29",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.6264.3444.6257 Safari/537.21",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.2345.6089.8970 Safari/537.22",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.9310.287.6732 Safari/537.6",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.1377.9273.7735 Safari/537.14"};

    static String[] uuid = {
            "cd1a9ca261144b33bc8c.1591507012.1.0.",
            "b125d52020a94acd8b5c.1591507012.1.0.0"
    };

    public void getData() {
        onlineDecrypt();
    }

    public void onlineDecrypt() {
        // String url = apiUrl + "uuid=dab4577b0f964ebea181.1591278152.1.0.0&userid=-1&limit=1&offset=0&q=%25E7%25BE%258E%25E9%25A3%259F&Referer=https://jn.meituan.com/%25E7%25BE%258E%25E9%25A3%259F";
        String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=dab4577b0f964ebea181.1591278152.1.0.0&userid=-1&limit=64&offset=0&q=美食&Referer=https://jn.meituan.com/美食";
        Document document = doHttp(url);
        String jsonResult = document.text();
        // log.info("result : {}", jsonResult);
        System.out.println(jsonResult);
    }


    private Document doHttp(String url) {
        try {
            return Jsoup.connect(url)
                    .ignoreContentType(true)
                    .proxy(null)
                    .userAgent(ua[new Random().nextInt(ua.length)])
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=dab4577b0f964ebea181.1591278152.1.0.0&userid=-1&limit=1&offset=0&q=美食&Referer=https://jn.meituan.com/美食";
        String userAgent = ua[new Random().nextInt(ua.length)];
        System.out.println(userAgent);
        try {
            Document document = Jsoup.connect(url)
                    .ignoreContentType(true)
                    //  .proxy(null)
                    .userAgent(userAgent)
                    .get();
            System.out.println(document.text());
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
