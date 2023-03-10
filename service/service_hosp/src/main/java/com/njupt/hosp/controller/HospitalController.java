package com.njupt.hosp.controller;

import com.njupt.common.result.Result;
import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.service.HospitalSetService;
import com.njupt.hosp.vo.hosp.HospitalQueryVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hosp/hospitalSet")
@Api(tags = "医院设置管理")
@CrossOrigin
public class HospitalController {
    @Autowired
    private HospitalSetService hospitalSetService;

    //查询医院设置表的所有信息
    @GetMapping("/findAll")
    @ApiOperation(value = "查询医院设置表的所有信息", notes = "获取医院设置表中的所有信息")
    public Result findAllHospitalSet() {
        List<HospitalSet> list = hospitalSetService.list();
        return Result.ok(list);
    }

    //逻辑删除医院设置
    @DeleteMapping("/{id}")
    @ApiOperation(value = "逻辑删除医院设置", notes = "根据医院的Id来删除医院设置表中的信息")
    public Result removeHospitalSet(@PathVariable Long id) {
        boolean flag = hospitalSetService.removeById(id);
        return flag ? Result.ok() : Result.fail();
    }

    //条件查询带分页
    @PostMapping("/findPage/{current}/{limit}")
    @ApiOperation(value = "带分页的条件查询", notes = "根据Hosname,Hoscode进行分页查询")
    public Result findPageHospitalSet(@PathVariable Long current,
                                      @PathVariable Long limit,
                                      @RequestBody(required = false) HospitalQueryVo hospitalQueryVo) {
        return hospitalSetService.findPageHospitalSet(current, limit, hospitalQueryVo);
    }

    //添加医院设置
    @PostMapping("/saveHospitalSet")
    @ApiOperation(value = "添加医院设置", notes = "向医院配置表中添加一条信息")
    public Result saveHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.saveHospitalSet(hospitalSet);
        return flag ? Result.ok() : Result.fail();
    }

    //根据Id获取医院设置
    //TODO 新建一个vo类来进行返回值（直接返回HospitalSet不完善）
    @PostMapping("/getHospSet/{id}")
    @ApiOperation(value = "根据Id获取医院设置", notes = "根据id从医院设置表中查询")
    public Result getHospSet(@PathVariable Long id) {
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return Result.ok(hospitalSet);
    }

    //修改医院设置
    @PutMapping("/updateHospitalSet")
    @ApiOperation(value = "修改医院设置", notes = "根据id来修改医院的设置")
    public Result updateHospitalSet(@RequestBody HospitalSet hospitalSet) {
        boolean flag = hospitalSetService.updateById(hospitalSet);
        return flag ? Result.ok() : Result.fail();
    }

    //批量删除医院设置
    @DeleteMapping("/batchRemove")
    @ApiOperation(value = "批量删除医院设置", notes = "根据医院id来进行批量删除")
    public Result batchRemoveHospitalSet(@RequestBody List<Long> ids) {
        boolean flag = hospitalSetService.removeByIds(ids);
        return flag ? Result.ok() : Result.fail();
    }

    //医院设定锁定和解锁
    @PutMapping("/lockHospitalSet/{id}/{status}")
    @ApiOperation(value="锁定/解锁医院设定",notes = "将医院设定为锁定或者解锁状态")
    public Result lockHospitalSet(@PathVariable Long id,@PathVariable Integer status){
        //根据id查询医院设置信息
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        //设置状态
        hospitalSet.setStatus(status);
        //调用方法
        boolean flag = hospitalSetService.updateById(hospitalSet);
        return flag? Result.ok():Result.fail();
    }

    //发送签名密钥
    @PutMapping("/sendKey/{id}")
    @ApiOperation(value="发送签名密钥",notes = "通过短信发送签名密钥")
    public Result sendKey(@PathVariable Long id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        String signKey = hospitalSet.getSignKey();
        String hoscode = hospitalSet.getHoscode();
        //TODO 发送短信
        return Result.ok();
    }
}
