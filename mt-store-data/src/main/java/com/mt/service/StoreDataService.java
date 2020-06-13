package com.mt.service;

/**
 * @author : shu
 * @description: 美团数据获取服务
 */
public interface StoreDataService {

    void getStoreData(String keyword);

    void taskProcess(String keyword, int limit, int offset, String areaId);

}
