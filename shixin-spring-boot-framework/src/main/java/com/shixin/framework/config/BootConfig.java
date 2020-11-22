package com.shixin.framework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 框架配置类，使用该框架时需引入的配置
 *
 * @author shixin
 * @date 2020/10/18 9:46 上午
 */
@Configuration
@ComponentScan({"com.shixin.framework.*"})
public class BootConfig {
}
