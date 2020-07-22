package com.mt.dao;

import com.mt.entity.Area;
import com.mt.entity.TaArea;
import java.util.List;

public interface TaAreaMapper extends AreaMapper {
    int deleteByPrimaryKey(String id);

    int insert(TaArea record);

    TaArea selectByPrimaryKey(String id);

    List<Area> selectAll();

    int updateByPrimaryKey(TaArea record);
}