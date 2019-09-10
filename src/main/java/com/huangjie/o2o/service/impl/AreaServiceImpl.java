package com.huangjie.o2o.service.impl;

import com.huangjie.o2o.entity.Area;
import com.huangjie.o2o.repository.AreaMapper;
import com.huangjie.o2o.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author huangjie
 * @date 2019/09/04
 * @blame 黄杰
 **/
@Service
public class AreaServiceImpl implements AreaService {
    @Resource
    private AreaMapper areaMapper;
    @Override
    public List<Area> listAllArea() {
        return areaMapper.queryArea();
    }

    @Override
    public int insertArea(Area area) {
        return areaMapper.insertArea(area);
    }

    @Override
    public Area findAreaById(Long areaId) {
        return areaMapper.findAreaById(areaId);
    }
}
