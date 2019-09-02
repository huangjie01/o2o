package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Data
public class ProductCategory {
    private Long productCategoryID;
    private Long shopID;
    private String productCategoryName;
    private Integer priority;
    private Date createTime;
    private Date updateTime;
}
