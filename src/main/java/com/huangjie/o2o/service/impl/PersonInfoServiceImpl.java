package com.huangjie.o2o.service.impl;

import com.huangjie.o2o.entity.PersonInfo;
import com.huangjie.o2o.repository.PersonInfoMapper;
import com.huangjie.o2o.service.PersonInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author huangjie
 * @date 2019/09/10
 * @blame 黄杰
 **/
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Resource
    private PersonInfoMapper personInfoMapper;
    @Override
    public int insertPersonInfo(PersonInfo personInfo) {
        return personInfoMapper.insertPersonInfo(personInfo);
    }
}
