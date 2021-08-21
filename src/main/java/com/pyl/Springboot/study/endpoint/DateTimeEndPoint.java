package com.pyl.Springboot.study.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PYL
 */
@Endpoint(id = "datetime")
public class DateTimeEndPoint {

    private String format = "yyyy-MM-dd HH:mm:ss";

    /**
     * 用来显示监控指标
     * localhost:/8080/pyl/actuator/datetime
     */
    @ReadOperation
    public Map<String,Object> info(){

        Map<String,Object> info = new HashMap<>();
        info.put("name","pyl");
        info.put("age","21");
        info.put("datetime", new SimpleDateFormat(format).format(new Date()));

        return info;
    }

    /**
     * 动态监控显示指标
     * @param format
     */
    @WriteOperation
    public void setFormat(String format){
        this.format = format;
    }
}
