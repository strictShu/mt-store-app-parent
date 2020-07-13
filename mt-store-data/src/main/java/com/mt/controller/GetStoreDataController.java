package com.mt.controller;

import com.mt.common.util.JSONResult;
import com.mt.service.ProxyRequestService;
import com.mt.service.StoreDataService;
import com.mt.task.MtTask;
import com.sun.java.browser.net.ProxyService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/open/data")
public class GetStoreDataController {


    @Autowired
    private StoreDataService storeDataService;

    @Autowired
    private MtTask mtTask;

    @Autowired
    private ProxyRequestService proxyService;

    @RequestMapping("/test")
    public JSONResult getData(HttpServletRequest request) {

        String keyword = request.getParameter("keyword");
        if (StringUtils.isBlank(keyword)) {
            keyword = "美食";
        }
        storeDataService.getStoreData(keyword);
        return JSONResult.success();
    }

    @RequestMapping("/task")
    public String doTask(){
        mtTask.getData();
        return "success";
    }

    @RequestMapping("/proxy")
    public String getProxy(){
        Map proxy = proxyService.getProxy();
        return proxy.get("ip")+":"+proxy.get("port");
    }



    @RequestMapping("/proxy2")
    public String shunDaoProxy(){
        //String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=b125d52020a94acd8b5c.1591507012.1.0.0&userid=-1&limit=64&offset=1&areaId=139&q=%25E9%2585%2592%25E5%25BA%2597&Referer=https://jn.meituan.com/%25E9%2585%2592%25E5%25BA%2597";
        String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=b125d52020a94acd8b5c.1591507012.1.0.0&userid=-1&limit=64&offset=1&areaId=139&q=%25E9%2585%2592%25E5%25BA%2597&Referer=https://jn.meituan.com/%25E9%2585%2592%25E5%25BA%2597";
       // String url = "https://apimobile.meituan.com/group/v4/poi/pcsearch/96?uuid=cd1a9ca261144b33bc8c.1591507012.1.0.&userid=-1&limit=64&offset=3&areaId=13354&q=%25E8%259B%258B%25E7%25B3%2595&Referer=https://jn.meituan.com/%25E8%259B%258B%25E7%25B3%2595";
        Document urlProxyContent = proxyService.getUrlProxyContent(url);
        return urlProxyContent.text();
    }

}
