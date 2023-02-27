package com.njupt.hosp.controller;

import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.service.HospitalSetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@Api(tags = "医院设置表 相关接口")
public class HospitalController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //查询医院设置表的所有信息
    @GetMapping("/findAll")
    @ApiOperation(value = "查询医院设置表的所有信息",notes = "获取医院设置表中的所有信息")
    public List<HospitalSet> findAllHospitalSet(){
        return hospitalSetService.list();
    }


}
