package com.mt.service;

import com.mt.entity.Area;

/**
 * @author : shu
 * @description: 美团数据获取服务
 */
public interface StoreDataService {

    void getStoreData(String keyword);

    void taskProcess(String keyword, int limit, int offset, Area area);

}
