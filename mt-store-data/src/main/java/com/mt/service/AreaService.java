package com.mt.service;

import com.mt.dao.AreaMapper;
import com.mt.dao.JnAreaMapper;
import com.mt.dao.TaAreaMapper;
import com.mt.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/13
 */


@Service
public class AreaService {
    @Autowired
    private JnAreaMapper jnAreaMapper;
    @Autowired
    private TaAreaMapper taAreaMapper;


    @Autowired
    private AreaMapper areaMapper;

    Map map;

    @PostConstruct
    public void getCityAreaList() {
        map = new HashMap();
        map.put("96", jnAreaMapper);
        map.put("226", taAreaMapper);
    }


    public List<Area> queryAreaList(String cityId) {
        AreaMapper areaMapper = (AreaMapper) map.get(cityId);
        return areaMapper.selectAll();
    }



    public List<Area> allAreaList() {
        return areaMapper.selectAll();
    }
}



