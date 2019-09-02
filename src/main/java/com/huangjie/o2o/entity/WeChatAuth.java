package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/08/31
 * @blame 黄杰
 **/
@Data
public class WeChatAuth {
    private Long weChatAuthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;

}
