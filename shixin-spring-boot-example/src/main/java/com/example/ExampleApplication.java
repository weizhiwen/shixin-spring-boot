package com.example;

import com.shixin.framework.config.BootConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author shixin
 * @date 2020/10/18 5:07 下午
 */
@SpringBootApplication
@Import({BootConfig.class})
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }
}
