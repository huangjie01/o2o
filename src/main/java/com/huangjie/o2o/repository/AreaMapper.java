package com.huangjie.o2o.repository;

import com.huangjie.o2o.entity.Area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author huangjie
 * @date 2019/09/02
 * @blame 黄杰
 **/
@Mapper
public interface AreaMapper {
    List<Area> queryArea();
}
