package com.pyl.Springboot.study.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * springboot 配置
 */
@Data
@Component
@ConfigurationProperties(prefix = "pyl.springboot")
public class SpringBootConfig {
    private String version;
    private String name;
}
