package com.mt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Area {
    private String id;

    private String parentId;

    private String areaName;

    private String regionName;

    private String cityId;

    private String cityAcronym;

    private String cityName;

    private Integer version;

    private Date createTime;

    private Date updateTime;


}