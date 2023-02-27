package com.njupt.hosp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.njupt.hosp.mapper.HospitalSetMapper;
import com.njupt.hosp.model.hosp.HospitalSet;
import com.njupt.hosp.service.HospitalSetService;
import org.springframework.stereotype.Service;

@Service("hospitalService")
public class HospitalServiceImpl extends ServiceImpl<HospitalSetMapper, HospitalSet> implements HospitalSetService {

}
