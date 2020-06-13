package com.mt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {
    private String id;

    private String parentId;

    private String areaName;

    private String regionName;

    private Integer version;

    private Date createTime;

    private Date updateTime;

}