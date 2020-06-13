package com.mt.controller;

import com.mt.common.util.JSONResult;
import com.mt.service.ProxyRequestService;
import com.mt.service.StoreDataService;
import com.mt.task.MtTask;
import com.sun.java.browser.net.ProxyService;
import org.apache.commons.lang3.StringUtils;
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

}
