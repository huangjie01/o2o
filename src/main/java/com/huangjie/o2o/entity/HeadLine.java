package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/08/31
 * @blame 黄杰
 **/
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date updateTime;
}
