package com.pyl.Springboot.Coupons;


import org.springframework.boot.SpringApplication;

//应用启动类
public class SpringBootApplication {
    public static void main(String[] args) {
        //1.通过静态run方法
        SpringApplication.run(SpringBootApplication.class,args);

        //2.通过api调整应用行为
        //SpringApplication application = new SpringApplication(SpringBootApplication.class);
        //application.run(args);

    }
}
