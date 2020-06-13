package com.mt.common.threadpool;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;


/**
 * @author:李小龙
 * @createTime: 2020-06-06 12:10
 * @description: 数据同步的线程池配置
 * @modifyTime:
 * @modifyDescription:
 */
@Component
public class DataConsistenceThreadPool {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger("thread_pool_log");

    ThreadPoolExecutor executor;

    @Value("#{ @environment['threadpool.devicesync.core'] ?: 30 }")
    public int coreSize; // 核心线程数，常驻线程的大小
    @Value("#{ @environment['threadpool.devicesync.max'] ?: 30 }")
    public int maxSize;// 线程池最大值
    @Value("#{ @environment['threadpool.devicesync.keepLive'] ?: 2 }")
    public long keepLiveTime;// 线程空闲时间，默认单位为 分钟， 默认2分钟
    @Value("#{ @environment['threadpool.devicesync.maxQueueSize'] ?: 2000000 }")
    public int maxQueueSize;// 任务队列大小，默认 2000000


    private LocalDateTime bootstrapTime;

    private AtomicReference<LocalDateTime> lastTaskTime;

    @PostConstruct
    public void initTheBean() {
        executor = new ThreadPoolExecutor(coreSize,
                maxSize,
                keepLiveTime,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>(maxQueueSize),
                getThreadFactory(),
                new DataConsistenceThreadPoolRejectHandler()
        );
        bootstrapTime = LocalDateTime.now();
        lastTaskTime = new AtomicReference<>();
    }

    /**
     * @author:李小龙
     * @createTime: 2020-06-06 15:44
     * @description: 线程拒绝策略
     * @modifyTime:
     * @modifyDescription:
     */
    private static class DataConsistenceThreadPoolRejectHandler extends ThreadPoolExecutor.AbortPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
            logger.error("线程池【数据核对】，任务队列已满，拒绝加入！，线程详细 : {}" + task);
            super.rejectedExecution(task, executor);
        }
    }


    /**
     * @author:李小龙
     * @createTime: 2020-06-10 17:16
     * @description: 生成  ThreadFactory ，添加 线程描述
     * @modifyTime:
     * @modifyDescription:
     */
    private ThreadFactory getThreadFactory() {
        ThreadFactoryBuilder factoryBuilder = new ThreadFactoryBuilder();
        factoryBuilder.setNameFormat("data-consistence-%d");
        factoryBuilder.setDaemon(false);
        factoryBuilder.setPriority(Thread.NORM_PRIORITY);
        return factoryBuilder.build();
    }

    /**
     * @author:李小龙
     * @createTime: 2020-06-04 15:47
     * @description: 提交任务 返回 Future
     * @modifyTime:
     * @modifyDescription:
     */
    public Future<?> submitTask(Runnable command) {
        Future<?> result = this.executor.submit(command);
        taskLastExecuteTime();
        return result;
    }

    /**
     * @author:李小龙
     * @createTime: 2020-06-04 15:47
     * @description: 直接提交任务
     * @modifyTime:
     * @modifyDescription:
     */
    public void executeTask(Runnable command) {
        taskLastExecuteTime();
        this.submitTask(command);
    }


    /**
     * @author:李小龙
     * @createTime: 2020-06-06 13:03
     * @description: 更新 线程池内最后一个任务的提交时间
     * @modifyTime:
     * @modifyDescription:
     */
    private void taskLastExecuteTime() {
        lastTaskTime.set(LocalDateTime.now());
    }


    /**
     * @author:李小龙
     * @createTime: 2020-06-06 16:02
     * @description: 返回当前线程池状态
     * @modifyTime:
     * @modifyDescription:
     */
    public String status() {
        Map data = new LinkedHashMap();
        data.put("poolSize", executor.getPoolSize()); // 核心线程数
        data.put("activeThreads", executor.getActiveCount()); // 活动线程数
        data.put("queuedTasks", executor.getQueue().size()); // 当前任务队列大小
        data.put("completedTasks", executor.getCompletedTaskCount()); // 已完成任务数
        data.put("taskCount", executor.getTaskCount());// 调度任务数： 其实等于 已完成数量+队列长度+当前活动线程数
        data.put("bootstrapTime", bootstrapTime);// 线程池启动时间 约等于系统启动时间
        data.put("lastTaskTime", lastTaskTime.get()); // 最后一个任务的提交时间
        String json = JSON.toJSONString(data);
        logger.info(json);
        return json;
    }

}
