package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Data
public class ShopAuthMap {
    private Long shopAuthId;
    private Long employeeId;
    private Long shopId;
    private String name;
    private String title;
    private Integer titleFlag;
    private Integer enableStatus;
    private Date createTime;
    private Date updateTime;
    private PersonInfo employee;
    private Shop shop;
}
