package com.njupt.hosp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njupt.common.result.Result;
import com.njupt.common.utils.MD5;
import com.njupt.hosp.mapper.HospitalSetMapper;
import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.service.HospitalSetService;
import com.njupt.hosp.vo.hosp.HospitalQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service("hospitalService")
public class HospitalServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

    //带分页的条件查询
    @Override
    public Result findPageHospitalSet( Long current, Long limit,HospitalQueryVo hospitalQueryVo) {
        //创建page对象，传递当前页，每页记录条数
        Page<HospitalSet> page = new Page<>(current, limit);
        //构造条件
        LambdaQueryWrapper<HospitalSet> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.hasText(hospitalQueryVo.getHosname()),HospitalSet::getHosname,hospitalQueryVo.getHosname())
                .eq(StringUtils.hasText(hospitalQueryVo.getHoscode()),HospitalSet::getHoscode,hospitalQueryVo.getHoscode());
        //调用方法实现分页查询
        Page<HospitalSet> hospitalSetPage = page(page, wrapper);
        return Result.ok(hospitalSetPage);
    }

    //添加医院设置
    @Override
    public boolean saveHospitalSet(HospitalSet hospitalSet) {
        //设置状态 1：可以使用，0：不能使用
        hospitalSet.setStatus(1);
        //签名密钥
        Random random=new Random();
        hospitalSet.setSignKey(MD5.encrypt(System.currentTimeMillis()+""+random.nextInt(1000)));
        //调用Service
        return save(hospitalSet);
    }
}
