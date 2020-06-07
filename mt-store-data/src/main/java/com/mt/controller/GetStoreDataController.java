package com.mt.controller;

import com.mt.common.util.JSONResult;
import com.mt.service.StoreDataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/open/data")
public class GetStoreDataController {


    @Autowired
    private StoreDataService storeDataService;

    @RequestMapping("/test")
    public JSONResult getData(HttpServletRequest request) {

        String keyword = request.getParameter("keyword");
        if (StringUtils.isBlank(keyword)) {
            keyword = "美食";
        }
        storeDataService.getStoreData(keyword);
        return JSONResult.success();
    }

}
