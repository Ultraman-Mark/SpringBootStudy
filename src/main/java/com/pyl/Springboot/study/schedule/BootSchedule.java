package com.pyl.Springboot.study.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * SpringBoot定时任务
 * Created by PYL
 * */
@Slf4j
//@Component
public class BootSchedule {
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(
            "HH:mm:ss"
    );

    /**
     * 上一次开始执行时间点后3秒再执行
     * */
    @Scheduled(fixedRate = 3000)
    public void schedule01(){
        log.info("schedule01 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 上一次执行完毕时间点之后3秒再执行
     * */
    @Scheduled(fixedDelay = 3000)
    public void schedule02(){
        log.info("schedule02 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 第一次延迟2秒之后执行。之后按照每3秒执行一次
     * */
    @Scheduled(initialDelay = 2000, fixedRate = 3000)
    public void schedule03(){
        log.info("schedule03 -> {}", LocalDateTime.now().format(fmt));
    }

    /**
     * 每3秒执行一次
     * */
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04(){
        log.info("schedule04 -> {}", LocalDateTime.now().format(fmt));
    }
}
