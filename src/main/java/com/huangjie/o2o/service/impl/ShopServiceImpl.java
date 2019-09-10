package com.huangjie.o2o.service.impl;

import com.huangjie.o2o.entity.Shop;
import com.huangjie.o2o.repository.ShopMapper;
import com.huangjie.o2o.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @date 2019/09/10
 * @blame 黄杰
 **/
@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;
    @Override
    public int insertShop(Shop shop) {
        return shopMapper.insertShop(shop);
    }
}
