package com.mt.controller;

import com.mt.common.util.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : shu
 * @description: 测试服务.
 */

@RestController
@RequestMapping("/open")
public class TestController {

    @RequestMapping("/test")
    public JSONResult test() {
        return JSONResult.success();
    }

}
