package com.mt.service;

import com.mt.dao.AreaMapper;
import com.mt.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/13
 */


@Service
public class AreaService {
    @Autowired
    private AreaMapper areaMapper;


    public List<Area> queryAreaList() {
        return areaMapper.selectAll();
    }
}
