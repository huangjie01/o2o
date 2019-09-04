package com.huangjie.o2o.service;

import com.huangjie.o2o.entity.Area;

import java.util.List;

/**
 * @author huangjie
 * @date 2019/09/04
 * @blame 黄杰
 **/
public interface AreaService {

    List<Area> listAllArea();
    int insertArea(Area area);
}
