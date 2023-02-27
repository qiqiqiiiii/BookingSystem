package com.njupt.hosp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.njupt.common.result.Result;
import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.vo.hosp.HospitalQueryVo;

public interface HospitalSetService extends IService<HospitalSet> {
    //带分页的条件查询
    Result findPageHospitalSet(Long current,Long limit,HospitalQueryVo hospitalQueryVo);

    //添加医院设置
    boolean saveHospitalSet(HospitalSet hospitalSet);
}
