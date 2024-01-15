package com.lwlve.atp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisConfig
 *
 * @author Liuzheng
 * @date 2023/12/22 9:51
 */

@Configuration
@MapperScan("com.lwlve.atp.*.dao")
public class MybatisConfig {
}
