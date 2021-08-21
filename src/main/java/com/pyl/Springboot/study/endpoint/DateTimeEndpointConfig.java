package com.pyl.Springboot.study.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by PYL
 */
@Configuration
public class DateTimeEndpointConfig {

    /**
     * 视频中的@ConditionalOnEnabledEndpoint注解在2.1.4版本中存在，
     * 但2.3.11版本中只找到@ConditionalOnAvailableEndpoint注解
     * 还不太清楚二者的不同，但测试数据的使用还是正常的，推测可能在2.3版本对注解进行了更换
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnAvailableEndpoint
//    @ConditionalOnEnabledEndpoint
    public DateTimeEndPoint dateTimeEndPoint(){
        return new DateTimeEndPoint();
    }
}
