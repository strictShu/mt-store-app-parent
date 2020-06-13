package com.mt.controller;

import com.alibaba.fastjson.JSON;
import com.mt.common.util.JSONResult;
import com.mt.dao.AreaMapper;
import com.mt.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author : shu
 * @description: 测试服务.
 */

@RestController
@RequestMapping("/open")
public class TestController {


    @Autowired
    private AreaMapper areaMapper;


    @RequestMapping("/test")
    public JSONResult test() {
        return JSONResult.success();
    }

    String[] area = {
           "{\"id\":27619,\"name\":\"环南湖\",\"regionName\":\"环南湖\",\"count\":2}","{\"id\":27646,\"name\":\"钢城银座\",\"regionName\":\"钢城银座\",\"count\":12}","{\"id\":27647,\"name\":\"新兴广场\",\"regionName\":\"新兴广场\",\"count\":15}","{\"id\":27648,\"name\":\"鲁百商厦\",\"regionName\":\"鲁百商厦\",\"count\":7}","{\"id\":28637,\"name\":\"中心公园\",\"regionName\":\"中心公园\",\"count\":\"\"}","{\"id\":28694,\"name\":\"鑫利不锈钢公司\",\"regionName\":\"鑫利不锈钢公司\",\"count\":\"\"}","{\"id\":32172,\"name\":\"火车站与汽车站\",\"regionName\":\"火车站与汽车站\",\"count\":4}","{\"id\":32173,\"name\":\"人民医院寨子分院\",\"regionName\":\"人民医院寨子分院\",\"count\":\"\"}","{\"id\":32174,\"name\":\"植物园与双凤山公园\",\"regionName\":\"植物园与双凤山公园\",\"count\":\"\"}","{\"id\":32175,\"name\":\"钢城科技艺术培训学校\",\"regionName\":\"钢城科技艺术培训学校\",\"count\":6}","{\"id\":32176,\"name\":\"莱钢医院\",\"regionName\":\"莱钢医院\",\"count\":8}","{\"id\":32177,\"name\":\"风景区\",\"regionName\":\"风景区\",\"count\":\"\"}"
    };
    @RequestMapping("/save")
    public JSONResult save() {
        Date date = new Date();
        for (String s : area) {
            Map map = JSON.parseObject(s, Map.class);
            Integer id = (Integer) map.get("id");
            String name = (String) map.get("name");
            String regionName = (String) map.get("regionName");
            Area area = new Area();
            area.setId(id.toString());
            area.setAreaName(name);
            area.setRegionName(regionName);
            area.setParentId("3232");

            area.setVersion(0);
            area.setUpdateTime(date);
            area.setCreateTime(date);
            areaMapper.insert(area);
        }


        return JSONResult.success();
    }


    public static void main(String[] args) {

      //  System.out.println(area[0]);
    }


}
