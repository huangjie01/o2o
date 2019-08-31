package com.huangjie.o2o.entity;


import lombok.Data;
import java.util.Date;

/**
 * @author huangjie
 * @date 2019/08/31
 * @blame 黄杰
 **/
@Data
public class Area {
    private Long areaID;
    private String areaName;
    private Integer priority;
    private String areaDesc;
    private Date createTime;
    private Date updateTime;
}
