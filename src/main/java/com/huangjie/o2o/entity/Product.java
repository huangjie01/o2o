package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Data
public class Product {
    private Long productId;
    private String productName;
    private String productDesc;
    private String imgAddr;
    private String normalPrice;
    private String promotionPrice;
    private Integer priority;
    private Date createTime;
    private Date updateTime;
    private Integer enableStatus; //-1 不可用 0 下架 1 在前端系统展示
    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;
}
