package com.huangjie.o2o.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Data
public class ProductImg {
    private Long productImgId;
    private Long productID;
    private String imgAddr;
    private String imgDesc;
    private Integer priority;
    private Date createTime;

}
