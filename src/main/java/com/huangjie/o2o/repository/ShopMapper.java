package com.huangjie.o2o.repository;

import com.huangjie.o2o.entity.Shop;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangjie
 * @date 2019/09/10
 * @blame 黄杰
 **/
@Mapper
public interface ShopMapper {

    int insertShop(Shop shop);
}
