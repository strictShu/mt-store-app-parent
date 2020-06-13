package com.mt.task;

import com.mt.common.threadpool.DataConsistenceThreadPool;
import com.mt.entity.Area;
import com.mt.service.AreaService;
import com.mt.service.StoreDataService;
import com.mt.service.impl.MeiTuanStoreDataServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/13
 */
@Service
@Slf4j
public class MtTask {

    @Autowired
    private DataConsistenceThreadPool dataConsistenceThreadPool;

    @Autowired
    private StoreDataService storeDataService;


    @Autowired
    private AreaService areaService;

    /**
     * 数据页码最大值
     */
    @Value("#{ @environment['page.offset.max'] ?: 20 }")
    public int offset;
    /**
     * 每页数量
     */
    @Value("#{ @environment['page.size'] ?: 64 }")
    public int pageSize;

//"美食","烧烤",
    List<String> keyword = Arrays.asList(  "海鲜", "外卖", "家常菜", "自助餐", "小吃", "蛋糕", "水果", "奶茶", "火锅", "面馆",
            "酒店", "民宿", "宾馆", "洗浴", "足疗", "按摩", "保健",
            "酒吧", "采摘", "网吧", "宠物", "健身", "轰趴", "美容", "美发", "摄影", "儿童摄影");

    public List<Area> areas;

    @PostConstruct
    public void init() {
        initAreaId();
    }

    private void initAreaId() {
        areas = areaService.queryAreaList();
    }


    // @Scheduled(cron = "0 0 */1 * * ?")
    public void getData() {

        keyword.forEach(keyword -> {
            taskPloy(keyword);
            // dataConsistenceThreadPool.submitTask(() -> taskPloy(keyword));
        });
    }

    /**
     * @param keyword
     */
    public void taskPloy(String keyword) {
        // todo
        for (Area area : areas) {
            String areaId = area.getId();
            if (areaId.equals("0")){
                continue;
            }
            for (int i = 0; i < offset; i++) {
                // for (Area area : areas) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                storeDataService.taskProcess(keyword, pageSize, i, areaId);
            }
        }
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void clearProxy() {
        MeiTuanStoreDataServiceImpl meiTuanStoreDataService = (MeiTuanStoreDataServiceImpl) storeDataService;
        if (meiTuanStoreDataService.proxy != null) {
            log.info("清除代理");
            meiTuanStoreDataService.proxy = null;
        }
    }
}
