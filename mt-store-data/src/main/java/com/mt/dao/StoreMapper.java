package com.mt.dao;

import com.mt.entity.Store;
import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(String id);

    int insert(Store record);

    Store selectByPrimaryKey(String id);

    List<Store> selectAll();

    int updateByPrimaryKey(Store record);
}