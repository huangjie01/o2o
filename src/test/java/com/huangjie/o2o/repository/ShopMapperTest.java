package com.huangjie.o2o.repository;

import com.huangjie.o2o.entity.Area;
import com.huangjie.o2o.entity.Shop;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @date 2019/09/10
 * @blame 黄杰
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShopMapperTest {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private AreaMapper areaMapper;
    @Test
    public void insertShop() {
        Shop shop=new Shop();
        shop.setAdvice("advice");
        Area area=areaMapper.findAreaById(1L);
        shop.setArea(area);
        shop.setShopName("男士最喜欢的");
        shop.setPhone("17702163306");
        shop.setShopAddr("成都市高新区软件园E区");
        shop.setPriority(1);
        shop.setShopImg("");
        shopMapper.insertShop(shop);
    }
}
