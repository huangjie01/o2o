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
public class Shop {
    private Long shopId;
    private Long ownerId;
    private Long shopCategoryId;
    private String shopName;
    private String shopDesc;
    private String shopAddr;
    private String phone;
    private String shopImg;
    private Double longitude;
    private Double latitude;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private Integer enableStatus;
    private String advice;

    private List<ShopAuthMap> staffList;
    private Area area;
    private ShopCategory shopCategory;
    private ShopCategory parentCategory;
}
