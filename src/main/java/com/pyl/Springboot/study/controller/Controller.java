package com.pyl.Springboot.study.controller;


import com.pyl.Springboot.study.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PYL
 * */
@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {

    // SpringBoot Config
    private final SpringBootConfig springBootConfig;

    @Value("${pyl.springboot.version}")
    private String version;

    @Value("${pyl.springboot.name}")
    private String name;

    public Controller(SpringBootConfig springBootConfig) {
        this.springBootConfig = springBootConfig;
    }

    /**
    * 第一种方式的数据注入
    * 127.0.0.1:8000/pyl/springboot/conf_inject_1
     * */
    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject: {}, {}",version,name);
    }

    /**
     * 第一种方式的数据注入
     * 127.0.0.1:8000/pyl/springboot/conf_inject_2
     */
    @GetMapping("/conf_inject_2")
    public void secondConfInject(){
        log.info("second conf inject: {}, {}",springBootConfig.getVersion(),springBootConfig.getName());
    }
}
