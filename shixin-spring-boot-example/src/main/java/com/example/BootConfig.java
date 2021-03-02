package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

/**
 * 框架配置类，使用该框架时需引入的配置
 *
 * @author shixin
 * @date 2020/10/18 9:46 上午
 */
@Configuration
@ComponentScan(value = {"com.shixin.framework.*", "com.shixin.dal"})
@EnableJpaRepositories(value = "com.example.repository")
@EntityScan("com.example.entity")
@EnableJpaAuditing
@EnableMongoAuditing
public class BootConfig {
}
