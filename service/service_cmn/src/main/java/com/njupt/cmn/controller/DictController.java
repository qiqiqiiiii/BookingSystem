package com.njupt.cmn.controller;

import com.njupt.cmn.service.DictService;
import com.njupt.common.result.Result;
import com.njupt.hosp.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/cmn/dict")
@Api(tags = "数据字典管理")
@CrossOrigin
public class DictController {
    @Autowired
    private DictService dictService;

    //根据数据id查询子数据列表
    @GetMapping("/findChildData/{id}")
    @ApiOperation(value = "根据父id查询子数据列表", notes = "获取在该id下的所有子数据列表")
    public Result findChildData(@PathVariable Long id){
        List<Dict> childData = dictService.findChildData(id);
        return Result.ok(childData);
    }


}
