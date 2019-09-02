package com.huangjie.o2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.huangjie.o2o.repository")
public class O2oApplication {
    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }
}
