package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/08/31
 * @blame 黄杰
 **/
@Data
public class LocalAuth {
    private Long localAuthID;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
    private PersonInfo personInfo;
}
