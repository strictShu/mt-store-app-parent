package com.mt.common.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.function.Supplier;


@Component
public class TaskTimeOutUtils {

    ExecutorService executor = Executors.newFixedThreadPool(10);


    public Object doInvokeOperate(Supplier supplier, Integer timeOut, TimeUnit timeUnit) {
        return doInvokeOperate(supplier, timeOut, timeUnit, Object.class);
    }


    public <T> T doInvokeOperate(Supplier supplier,
                                 Integer timeOut,
                                 TimeUnit timeUnit,
                                 Class<T> clazz) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier, executor);
        try {
            return (T) completableFuture.get(timeOut, timeUnit);
        } catch (TimeoutException e) {
            completableFuture.cancel(true);
            e.printStackTrace();
            throw new RuntimeException(" timeout ");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TaskTimeOutUtils taskTimeOutUtils = new TaskTimeOutUtils();
        String val = taskTimeOutUtils.doInvokeOperate(() -> {
         /*   try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            return "1";
        }, 1, TimeUnit.SECONDS, String.class);

        System.err.println(val);
    }


}
