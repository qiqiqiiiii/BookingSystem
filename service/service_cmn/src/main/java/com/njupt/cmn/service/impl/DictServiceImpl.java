package com.njupt.cmn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njupt.cmn.mapper.DictMapper;
import com.njupt.cmn.service.DictService;
import com.njupt.hosp.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service("dictService")
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    //根据数据id查询子数据列表
    @Override
    public List<Dict> findChildData(Long id) {
        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dict::getParentId, id);
        //这里使用生成链式调用，需要在Dict类上添加@accessors(chain = true)
        return list(queryWrapper).stream()
                .map(dict -> dict.setHasChildren(isChildren(dict.getId())))
                .collect(Collectors.toList());
    }

    //判断id下面是否有子节点
    public boolean isChildren(Long id) {
        LambdaQueryWrapper<Dict> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dict::getParentId, id);
        return count(queryWrapper) > 0;
    }
}
