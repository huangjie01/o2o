package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/08/31
 * @blame 黄杰
 **/
@Data
public class PersonInfo {
    private Long userId;
    private String userName;
    private String  profileImg;
    private String email;
    private String gender;
    private Integer enableStatus;
    private Integer userType;
    private Date createTime;
    private Date updateTime;
}
