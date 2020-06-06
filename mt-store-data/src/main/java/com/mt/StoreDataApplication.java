package com.mt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author : shu
 * @description:
 * @date: 2020/6/6
 */

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class StoreDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreDataApplication.class, args);
    }

}
