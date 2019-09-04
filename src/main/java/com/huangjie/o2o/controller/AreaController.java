package com.huangjie.o2o.controller;

import com.huangjie.o2o.entity.Area;
import com.huangjie.o2o.service.AreaService;
import com.huangjie.o2o.util.ResultVOUtils;
import com.huangjie.o2o.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author huangjie
 * @date 2019/09/04
 * @blame 黄杰
 **/
@RestController
@RequestMapping("/super/admin")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @ResponseBody
    @GetMapping("/list")
    public ResultVO<List<Area>> listAllAreaData(){
        List<Area> areaList = areaService.listAllArea();
      return   ResultVOUtils.success(areaList);
    }
}
