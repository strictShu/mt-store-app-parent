package com.mt.dao;

import com.mt.entity.Area;
import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(Area record);

    Area selectByPrimaryKey(String id);

    List<Area> selectAll();

    int updateByPrimaryKey(Area record);
}