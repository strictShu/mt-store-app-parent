package com.mt.service;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractHandlerStore implements StoreDataService {



    public abstract String getServiceName();

    public String[] ua = {
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
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.5463.5599.9443 Safari/537.25"};

    // todo 增加uuid
    public String[] uuid = {
            "cd1a9ca261144b33bc8c.1591507012.1.0."
    };

    public Map<String, String> cookies = new HashMap<>();

    public Map<String, String> headers = new HashMap<>();


    public void initHeader() {


        cookies.put("iuuid", "AE7EE5136792735A4355197D3109809A2827A977253525DA7E9370643E5213D6");
        //cookies.put("Hm_lvt_f66b37722f586a240d4621318a5a6ebe", "1591283315");
        cookies.put("_hc.v", "5fbed49b-0126-b4c6-949f-d3bbbd493cdf.1590556422");
        //cookies.put("iuuid", "14C2E0E37C3C59726808F58F3EF0C50A355318427C230B8BD766F22C537F15F0");
        cookies.put("_lxsdk", "AE7EE5136792735A4355197D3109809A2827A977253525DA7E9370643E5213D6");
        cookies.put("_lxsdk_cuid", "172548cf125c8-0f4244076da799-30647d01-1aeaa0-172548cf125c8");
        cookies.put("webp", "1");
        cookies.put("__utma", "74597006.1553331218.1590641905.1590641905.1591515435.2");
        cookies.put("__utmz", "74597006.1591515435.2.2.utmcsr=blog.csdn.net|utmccn=(referral)|utmcmd=referral|utmcct=/xing851483876/article/details/81842329");
        cookies.put("cityname", "%E6%B5%8E%E5%8D%97");
        cookies.put("latlng", "36.683988,117.057013,1591515464987");
        cookies.put("i_extend", "H__a100001__b2");
        cookies.put("rvct", "96");
    }


}
