package com.huangjie.o2o;

import com.huangjie.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class O2oApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void contextLoads() {
        RowMapper<Area> rowMapper=new BeanPropertyRowMapper<>(Area.class);
        List<Area> query = jdbcTemplate.query("SELECT * FROM tb_area", rowMapper);

        System.out.println(jdbcTemplate.toString());
        Assert.assertNotNull(jdbcTemplate);
    }

}
