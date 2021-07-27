package com.pyl.Springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 应用启动类
 * 1.@EnableScheduling允许当前任务开启定时任务
 * 2.@EnableAsync允许当前任务开启异步任务
 * Created by PYL
 */
@EnableAsync
@EnableScheduling
@SpringBootApplication
//包含@SpringbootConfiguration,@EnableAutoConfiguration（核心）,@ComponentScan三个关键注解
public class SpringBootStudyApplication {
    public static void main(String[] args) {
//        1.通过静态run方法
        SpringApplication.run(SpringBootStudyApplication.class,args);

//        2.通过api调整应用行为
//        SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);
//
//        3.SpringApplicationBuilder Fluent Api,链式调用

//        new SpringApplicationBuilder(SpringBootStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
