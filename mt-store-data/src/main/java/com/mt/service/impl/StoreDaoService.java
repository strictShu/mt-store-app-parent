package com.mt.service.impl;

import com.mt.dao.StoreMapper;
import com.mt.entity.Store;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StoreDaoService {


    @Autowired
    private StoreMapper storeMapper;

    public void insertData(Store store) {
        try {
            storeMapper.insert(store);
            log.info("写入success,id: {} ,名称 : {} ,手机号 : {}", store.getId(), store.getTitle(), store.getPhone());
        } catch (DuplicateKeyException e) {
            log.error("商店id已存在,id: {} ,名称 : {}", store.getId(), store.getTitle());
        } catch (Exception e) {
            log.error("写入异常.", e);
        }
    }
}
