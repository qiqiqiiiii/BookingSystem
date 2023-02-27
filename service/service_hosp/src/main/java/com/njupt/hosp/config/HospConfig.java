package com.njupt.hosp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.njupt.hosp.mapper")
public class HospConfig {
}
