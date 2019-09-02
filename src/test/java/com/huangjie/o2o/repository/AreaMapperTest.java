package com.huangjie.o2o.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {

    @Resource
    private AreaMapper areaMapper;
    @Test
    public void queryArea() {
        areaMapper.queryArea();
    }
}
