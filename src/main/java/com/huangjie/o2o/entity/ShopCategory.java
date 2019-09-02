package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date updateTime;
    private Long parentId;
}
