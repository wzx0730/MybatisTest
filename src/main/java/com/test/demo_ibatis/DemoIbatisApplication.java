package com.test.demo_ibatis;

import com.test.demo_ibatis.domain.ModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(ModuleConfig.class)
public class DemoIbatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoIbatisApplication.class, args);
    }

}
