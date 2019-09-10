package com.huangjie.o2o.repository;

import com.huangjie.o2o.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
        List<Area> areas = areaMapper.queryArea();
        System.out.println(areas.toString());
    }

    @Test
    public void findAreaById() {
        Area area = areaMapper.findAreaById(1L);
        System.out.println(area.toString());
    }

    @Test
    public void testInsert() {
        Area area = new Area();
        area.setAreaName("软件园E区");
        area.setAreaDesc("位置位于天府五街");
        area.setPriority(1);
        area.setCreateTime(new Date(System.currentTimeMillis()));
        area.setUpdateTime(new Date(System.currentTimeMillis()));
        areaMapper.insertArea(area);
    }
}
