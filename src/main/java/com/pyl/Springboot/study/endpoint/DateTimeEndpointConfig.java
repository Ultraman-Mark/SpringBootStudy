package com.pyl.Springboot.study.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by PYL
 */
@Configuration
public class DateTimeEndpointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnAvailableEndpoint
    @ConditionalOnEnabledEndpoint
    public DateTimeEndPoint dateTimeEndPoint(){
        return new DateTimeEndPoint();
    }
}
