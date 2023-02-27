package com.njupt.hosp.controller;

import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.service.HospitalSetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
//@Api(tags = "医院设置表 相关接口")
public class HospitalController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //查询医院设置表的所有信息
    @GetMapping("/findAll")
    //@ApiOperation(value = "查询医院设置表的所有信息",notes = "获取医院设置表中的所有信息")
    public List<HospitalSet> findAllHospitalSet(){
        return hospitalSetService.list();
    }

    //删除医院设置
    @DeleteMapping("/{id}")
    //@ApiOperation(value = "删除医院设置",notes = "根据医院的Id来删除医院设置表中的信息")
    public boolean removeHospitalSet(@PathVariable Long id){
        return hospitalSetService.removeById(id);
    }


}
