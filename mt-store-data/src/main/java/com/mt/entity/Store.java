package com.mt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Store {
    private String id;

    private String title;

    private String phone;

    private String city;

    private String address;

    private String areaname;

    private Double latitude;

    private Double longitude;

    private Double avgScore;

    private Integer comments;

    private String backcatename;

    private Integer storeId;

    private Integer avgPrice;

    private String sourceKey;

    private String sourceData;

    private Date creatTime;

    private Date updateTime;

}