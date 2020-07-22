package com.mt.controller;

import com.alibaba.fastjson.JSON;
import com.mt.common.util.JSONResult;
import com.mt.dao.JnAreaMapper;
import com.mt.dao.TaAreaMapper;
import com.mt.entity.AreaListEntity;
import com.mt.entity.HtmlArea;
import com.mt.entity.TaArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : shu
 * @description: 测试服务.
 */

@RestController
@RequestMapping("/open")
public class TestController {


    @Autowired
    private JnAreaMapper jnAreaMapper;

    @Autowired
    private TaAreaMapper taAreaMapper;

    @RequestMapping("/test")
    public JSONResult test() {
        return JSONResult.success();
    }
  static   String area = "{\n" +
            "\t\"areaList\": [{\n" +
            "\t\t\"id\": 0,\n" +
            "\t\t\"name\": \"全城\",\n" +
            "\t\t\"count\": 4594\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3225,\n" +
            "\t\t\"name\": \"泰山区\",\n" +
            "\t\t\"count\": 1678\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3226,\n" +
            "\t\t\"name\": \"岱岳区\",\n" +
            "\t\t\"count\": 491\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3228,\n" +
            "\t\t\"name\": \"肥城市\",\n" +
            "\t\t\"count\": 171\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3227,\n" +
            "\t\t\"name\": \"新泰市\",\n" +
            "\t\t\"count\": 243\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3229,\n" +
            "\t\t\"name\": \"宁阳县\",\n" +
            "\t\t\"count\": 58\n" +
            "\t}, {\n" +
            "\t\t\"id\": 3230,\n" +
            "\t\t\"name\": \"东平县\",\n" +
            "\t\t\"count\": 71\n" +
            "\t}],\n" +
            "\t\"areaObj\": {\n" +
            "\t\t\"3225\": [{\n" +
            "\t\t\t\"id\": 3225,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"泰山区\",\n" +
            "\t\t\t\"count\": 1678\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6659,\n" +
            "\t\t\t\"name\": \"火车站广场\",\n" +
            "\t\t\t\"regionName\": \"火车站广场\",\n" +
            "\t\t\t\"count\": 25\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6660,\n" +
            "\t\t\t\"name\": \"银座城市广场\",\n" +
            "\t\t\t\"regionName\": \"银座城市广场\",\n" +
            "\t\t\t\"count\": 66\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6661,\n" +
            "\t\t\t\"name\": \"大润发\",\n" +
            "\t\t\t\"regionName\": \"大润发\",\n" +
            "\t\t\t\"count\": 75\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6662,\n" +
            "\t\t\t\"name\": \"市政广场\",\n" +
            "\t\t\t\"regionName\": \"市政广场\",\n" +
            "\t\t\t\"count\": 39\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6663,\n" +
            "\t\t\t\"name\": \"金桥服装城\",\n" +
            "\t\t\t\"regionName\": \"金桥服装城\",\n" +
            "\t\t\t\"count\": 37\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6664,\n" +
            "\t\t\t\"name\": \"宝龙城市广场\",\n" +
            "\t\t\t\"regionName\": \"宝龙城市广场\",\n" +
            "\t\t\t\"count\": 117\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6665,\n" +
            "\t\t\t\"name\": \"银泰中心\",\n" +
            "\t\t\t\"regionName\": \"银泰中心\",\n" +
            "\t\t\t\"count\": 7\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6667,\n" +
            "\t\t\t\"name\": \"云海美食城\",\n" +
            "\t\t\t\"regionName\": \"云海美食城\",\n" +
            "\t\t\t\"count\": 25\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6668,\n" +
            "\t\t\t\"name\": \"东湖公园\",\n" +
            "\t\t\t\"regionName\": \"东湖公园\",\n" +
            "\t\t\t\"count\": 16\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6669,\n" +
            "\t\t\t\"name\": \"擂鼓石大街\",\n" +
            "\t\t\t\"regionName\": \"擂鼓石大街\",\n" +
            "\t\t\t\"count\": 23\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 6670,\n" +
            "\t\t\t\"name\": \"岱庙\",\n" +
            "\t\t\t\"regionName\": \"岱庙\",\n" +
            "\t\t\t\"count\": 33\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7335,\n" +
            "\t\t\t\"name\": \"长途汽车站\",\n" +
            "\t\t\t\"regionName\": \"长途汽车站\",\n" +
            "\t\t\t\"count\": 24\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7433,\n" +
            "\t\t\t\"name\": \"温州步行街\",\n" +
            "\t\t\t\"regionName\": \"温州步行街\",\n" +
            "\t\t\t\"count\": 40\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7531,\n" +
            "\t\t\t\"name\": \"泰山大街\",\n" +
            "\t\t\t\"regionName\": \"泰山大街\",\n" +
            "\t\t\t\"count\": 27\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7627,\n" +
            "\t\t\t\"name\": \"岱宗银座\",\n" +
            "\t\t\t\"regionName\": \"岱宗银座\",\n" +
            "\t\t\t\"count\": 13\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7630,\n" +
            "\t\t\t\"name\": \"花园银座\",\n" +
            "\t\t\t\"regionName\": \"花园银座\",\n" +
            "\t\t\t\"count\": 39\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7654,\n" +
            "\t\t\t\"name\": \"银座奥特莱斯\",\n" +
            "\t\t\t\"regionName\": \"银座奥特莱斯\",\n" +
            "\t\t\t\"count\": 21\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7657,\n" +
            "\t\t\t\"name\": \"齐鲁银座\",\n" +
            "\t\t\t\"regionName\": \"齐鲁银座\",\n" +
            "\t\t\t\"count\": 28\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7673,\n" +
            "\t\t\t\"name\": \"中百商厦\",\n" +
            "\t\t\t\"regionName\": \"中百商厦\",\n" +
            "\t\t\t\"count\": 24\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 7679,\n" +
            "\t\t\t\"name\": \"校场街\",\n" +
            "\t\t\t\"regionName\": \"校场街\",\n" +
            "\t\t\t\"count\": 39\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8562,\n" +
            "\t\t\t\"name\": \"财源街\",\n" +
            "\t\t\t\"regionName\": \"财源街\",\n" +
            "\t\t\t\"count\": 21\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8563,\n" +
            "\t\t\t\"name\": \"灵山大街\",\n" +
            "\t\t\t\"regionName\": \"灵山大街\",\n" +
            "\t\t\t\"count\": 35\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8564,\n" +
            "\t\t\t\"name\": \"龙潭路\",\n" +
            "\t\t\t\"regionName\": \"龙潭路\",\n" +
            "\t\t\t\"count\": 15\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8565,\n" +
            "\t\t\t\"name\": \"青年路\",\n" +
            "\t\t\t\"regionName\": \"青年路\",\n" +
            "\t\t\t\"count\": 16\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8566,\n" +
            "\t\t\t\"name\": \"岱道庵路\",\n" +
            "\t\t\t\"regionName\": \"岱道庵路\",\n" +
            "\t\t\t\"count\": 33\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8567,\n" +
            "\t\t\t\"name\": \"红门路\",\n" +
            "\t\t\t\"regionName\": \"红门路\",\n" +
            "\t\t\t\"count\": 3\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8568,\n" +
            "\t\t\t\"name\": \"新汽车站\",\n" +
            "\t\t\t\"regionName\": \"新汽车站\",\n" +
            "\t\t\t\"count\": 11\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8570,\n" +
            "\t\t\t\"name\": \"南湖路\",\n" +
            "\t\t\t\"regionName\": \"南湖路\",\n" +
            "\t\t\t\"count\": 44\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8571,\n" +
            "\t\t\t\"name\": \"文化路\",\n" +
            "\t\t\t\"regionName\": \"文化路\",\n" +
            "\t\t\t\"count\": 18\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8572,\n" +
            "\t\t\t\"name\": \"迎胜路\",\n" +
            "\t\t\t\"regionName\": \"迎胜路\",\n" +
            "\t\t\t\"count\": 26\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8573,\n" +
            "\t\t\t\"name\": \"科山路\",\n" +
            "\t\t\t\"regionName\": \"科山路\",\n" +
            "\t\t\t\"count\": 18\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 19199,\n" +
            "\t\t\t\"name\": \"万达广场西区\",\n" +
            "\t\t\t\"regionName\": \"万达广场西区\",\n" +
            "\t\t\t\"count\": 111\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 25316,\n" +
            "\t\t\t\"name\": \"科山路银座商城\",\n" +
            "\t\t\t\"regionName\": \"科山路银座商城\",\n" +
            "\t\t\t\"count\": 2\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 26199,\n" +
            "\t\t\t\"name\": \"淘你欢广场\",\n" +
            "\t\t\t\"regionName\": \"淘你欢广场\",\n" +
            "\t\t\t\"count\": 34\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 27617,\n" +
            "\t\t\t\"name\": \"老县衙\",\n" +
            "\t\t\t\"regionName\": \"老县衙\",\n" +
            "\t\t\t\"count\": 20\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 27618,\n" +
            "\t\t\t\"name\": \"山东农业大学南校区\",\n" +
            "\t\t\t\"regionName\": \"山东农业大学南校区\",\n" +
            "\t\t\t\"count\": 46\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 27806,\n" +
            "\t\t\t\"name\": \"新华城\",\n" +
            "\t\t\t\"regionName\": \"新华城\",\n" +
            "\t\t\t\"count\": 28\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 35586,\n" +
            "\t\t\t\"name\": \"创业大街\",\n" +
            "\t\t\t\"regionName\": \"创业大街\",\n" +
            "\t\t\t\"count\": 10\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 35625,\n" +
            "\t\t\t\"name\": \"东湖银座\",\n" +
            "\t\t\t\"regionName\": \"东湖银座\",\n" +
            "\t\t\t\"count\": 7\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 35665,\n" +
            "\t\t\t\"name\": \"天外村/泰山医学院\",\n" +
            "\t\t\t\"regionName\": \"天外村/泰山医学院\",\n" +
            "\t\t\t\"count\": 13\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 35920,\n" +
            "\t\t\t\"name\": \"通天街\",\n" +
            "\t\t\t\"regionName\": \"通天街\",\n" +
            "\t\t\t\"count\": 24\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 36374,\n" +
            "\t\t\t\"name\": \"万达广场东区\",\n" +
            "\t\t\t\"regionName\": \"万达广场东区\",\n" +
            "\t\t\t\"count\": 65\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 37375,\n" +
            "\t\t\t\"name\": \"方特欢乐世界\",\n" +
            "\t\t\t\"regionName\": \"方特欢乐世界\",\n" +
            "\t\t\t\"count\": 7\n" +
            "\t\t}],\n" +
            "\t\t\"3226\": [{\n" +
            "\t\t\t\"id\": 3226,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"岱岳区\",\n" +
            "\t\t\t\"count\": 491\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 8569,\n" +
            "\t\t\t\"name\": \"长城路\",\n" +
            "\t\t\t\"regionName\": \"长城路\",\n" +
            "\t\t\t\"count\": 76\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 36004,\n" +
            "\t\t\t\"name\": \"高新区/大学城\",\n" +
            "\t\t\t\"regionName\": \"高新区/大学城\",\n" +
            "\t\t\t\"count\": 99\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 38527,\n" +
            "\t\t\t\"name\": \"大汶口镇\",\n" +
            "\t\t\t\"regionName\": \"大汶口镇\",\n" +
            "\t\t\t\"count\": 4\n" +
            "\t\t}],\n" +
            "\t\t\"3227\": [{\n" +
            "\t\t\t\"id\": 3227,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"新泰市\",\n" +
            "\t\t\t\"count\": 243\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 15367,\n" +
            "\t\t\t\"name\": \"东方时代广场\",\n" +
            "\t\t\t\"regionName\": \"东方时代广场\",\n" +
            "\t\t\t\"count\": 17\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 15397,\n" +
            "\t\t\t\"name\": \"银座钻石铭厦\",\n" +
            "\t\t\t\"regionName\": \"银座钻石铭厦\",\n" +
            "\t\t\t\"count\": 25\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 15401,\n" +
            "\t\t\t\"name\": \"顺河路\",\n" +
            "\t\t\t\"regionName\": \"顺河路\",\n" +
            "\t\t\t\"count\": 15\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 15407,\n" +
            "\t\t\t\"name\": \"电视塔不夜城\",\n" +
            "\t\t\t\"regionName\": \"电视塔不夜城\",\n" +
            "\t\t\t\"count\": 35\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 15409,\n" +
            "\t\t\t\"name\": \"北园\",\n" +
            "\t\t\t\"regionName\": \"北园\",\n" +
            "\t\t\t\"count\": 8\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17265,\n" +
            "\t\t\t\"name\": \"丽苑小区\",\n" +
            "\t\t\t\"regionName\": \"丽苑小区\",\n" +
            "\t\t\t\"count\": 20\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17267,\n" +
            "\t\t\t\"name\": \"莲花山风景区\",\n" +
            "\t\t\t\"regionName\": \"莲花山风景区\",\n" +
            "\t\t\t\"count\": \"\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17269,\n" +
            "\t\t\t\"name\": \"新汶\",\n" +
            "\t\t\t\"regionName\": \"新汶\",\n" +
            "\t\t\t\"count\": 24\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17271,\n" +
            "\t\t\t\"name\": \"青云大厦\",\n" +
            "\t\t\t\"regionName\": \"青云大厦\",\n" +
            "\t\t\t\"count\": 16\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17273,\n" +
            "\t\t\t\"name\": \"银河路\",\n" +
            "\t\t\t\"regionName\": \"银河路\",\n" +
            "\t\t\t\"count\": 7\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17305,\n" +
            "\t\t\t\"name\": \"东周路\",\n" +
            "\t\t\t\"regionName\": \"东周路\",\n" +
            "\t\t\t\"count\": 13\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 17307,\n" +
            "\t\t\t\"name\": \"向阳路\",\n" +
            "\t\t\t\"regionName\": \"向阳路\",\n" +
            "\t\t\t\"count\": 13\n" +
            "\t\t}],\n" +
            "\t\t\"3228\": [{\n" +
            "\t\t\t\"id\": 3228,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"肥城市\",\n" +
            "\t\t\t\"count\": 171\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 14863,\n" +
            "\t\t\t\"name\": \"新合作购物广场\",\n" +
            "\t\t\t\"regionName\": \"新合作购物广场\",\n" +
            "\t\t\t\"count\": 8\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 14865,\n" +
            "\t\t\t\"name\": \"江南水街\",\n" +
            "\t\t\t\"regionName\": \"江南水街\",\n" +
            "\t\t\t\"count\": 5\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 14867,\n" +
            "\t\t\t\"name\": \"新城路\",\n" +
            "\t\t\t\"regionName\": \"新城路\",\n" +
            "\t\t\t\"count\": 46\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 14869,\n" +
            "\t\t\t\"name\": \"长山街\",\n" +
            "\t\t\t\"regionName\": \"长山街\",\n" +
            "\t\t\t\"count\": 28\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 26608,\n" +
            "\t\t\t\"name\": \"银座商城\",\n" +
            "\t\t\t\"regionName\": \"银座商城\",\n" +
            "\t\t\t\"count\": 3\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 26610,\n" +
            "\t\t\t\"name\": \"春秋古城\",\n" +
            "\t\t\t\"regionName\": \"春秋古城\",\n" +
            "\t\t\t\"count\": 3\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 26614,\n" +
            "\t\t\t\"name\": \"泰西中学\",\n" +
            "\t\t\t\"regionName\": \"泰西中学\",\n" +
            "\t\t\t\"count\": 4\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 28301,\n" +
            "\t\t\t\"name\": \"信业大厦\",\n" +
            "\t\t\t\"regionName\": \"信业大厦\",\n" +
            "\t\t\t\"count\": 11\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 28948,\n" +
            "\t\t\t\"name\": \"王瓜店镇\",\n" +
            "\t\t\t\"regionName\": \"王瓜店镇\",\n" +
            "\t\t\t\"count\": \"\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 29947,\n" +
            "\t\t\t\"name\": \"石横镇\",\n" +
            "\t\t\t\"regionName\": \"石横镇\",\n" +
            "\t\t\t\"count\": \"\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 29994,\n" +
            "\t\t\t\"name\": \"孙伯镇\",\n" +
            "\t\t\t\"regionName\": \"孙伯镇\",\n" +
            "\t\t\t\"count\": \"\"\n" +
            "\t\t}],\n" +
            "\t\t\"3229\": [{\n" +
            "\t\t\t\"id\": 3229,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"宁阳县\",\n" +
            "\t\t\t\"count\": 58\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 20921,\n" +
            "\t\t\t\"name\": \"宁阳县中心城区\",\n" +
            "\t\t\t\"regionName\": \"宁阳县中心城区\",\n" +
            "\t\t\t\"count\": 45\n" +
            "\t\t}],\n" +
            "\t\t\"3230\": [{\n" +
            "\t\t\t\"id\": 3230,\n" +
            "\t\t\t\"name\": \"全部\",\n" +
            "\t\t\t\"regionName\": \"东平县\",\n" +
            "\t\t\t\"count\": 71\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 19575,\n" +
            "\t\t\t\"name\": \"金汇街\",\n" +
            "\t\t\t\"regionName\": \"金汇街\",\n" +
            "\t\t\t\"count\": 25\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 19576,\n" +
            "\t\t\t\"name\": \"西华联\",\n" +
            "\t\t\t\"regionName\": \"西华联\",\n" +
            "\t\t\t\"count\": 3\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 29795,\n" +
            "\t\t\t\"name\": \"贯中大道\",\n" +
            "\t\t\t\"regionName\": \"贯中大道\",\n" +
            "\t\t\t\"count\": 2\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 29832,\n" +
            "\t\t\t\"name\": \"105国道\",\n" +
            "\t\t\t\"regionName\": \"105国道\",\n" +
            "\t\t\t\"count\": \"\"\n" +
            "\t\t}, {\n" +
            "\t\t\t\"id\": 29962,\n" +
            "\t\t\t\"name\": \"明湖中学\",\n" +
            "\t\t\t\"regionName\": \"明湖中学\",\n" +
            "\t\t\t\"count\": 2\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "\n" +
            "}";
    @RequestMapping("/save")
    public JSONResult save() {
        HtmlArea htmlArea = JSON.parseObject(area, HtmlArea.class);
        List<AreaListEntity> areaList = htmlArea.getAreaList();
        System.out.println(areaList);
        save("0",areaList);
        Map<String,List<AreaListEntity>> areaObj = htmlArea.getAreaObj();
        for (String parentId : areaObj.keySet()) {
            save(parentId,areaObj.get(parentId));
        }
        return JSONResult.success();
    }


    private  void save(String parentId, List<AreaListEntity> areaList ) {
        Date date = new Date();
        for (AreaListEntity areaListEntity : areaList) {
            TaArea area = new TaArea();
            area.setId(areaListEntity.getId()+"");
            area.setAreaName(areaListEntity.getName());
            area.setRegionName(areaListEntity.getRegionName());
            area.setParentId(parentId);
            area.setVersion(0);
            area.setUpdateTime(date);
            area.setCreateTime(date);
            System.out.println(area);

            try {
                taAreaMapper.insert(area);
            } catch (DuplicateKeyException e) {
                System.out.println(e);
            }
        }
        /*for (String s : area) {
            Map map = JSON.parseObject(s, Map.class);
            Integer id = (Integer) map.get("id");
            String name = (String) map.get("name");
            String regionName = (String) map.get("regionName");
            Area area = new Area();
            area.setId(id.toString());
            area.setAreaName(name);
            area.setRegionName(regionName);
            area.setParentId(parentId);
            area.setVersion(0);
            area.setUpdateTime(date);
            area.setCreateTime(date);
            areaMapper.insert(area);
        }*/
    }

    public static void main(String[] args) {
        HtmlArea htmlArea = JSON.parseObject(area, HtmlArea.class);

        List<AreaListEntity> areaList = htmlArea.getAreaList();
        System.out.println(areaList);
        saveTest("0",areaList);
        Map<String,List<AreaListEntity>> areaObj = htmlArea.getAreaObj();
        for (String parentId : areaObj.keySet()) {
            saveTest(parentId,areaList);
        }
    }

    private static void saveTest(String parentId, List<AreaListEntity> areaList) {
        Date date = new Date();
        for (AreaListEntity areaListEntity : areaList) {
            TaArea area = new TaArea();
            area.setId(areaListEntity.getId()+"");
            area.setAreaName(areaListEntity.getName());
            area.setRegionName(areaListEntity.getRegionName());
            area.setParentId(parentId);
            area.setVersion(0);
            area.setUpdateTime(date);
            area.setCreateTime(date);
            System.out.println(area);
        }
    }


}
