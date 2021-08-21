package com.pyl.Springboot.study.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by PYL
 */
@Slf4j
@Component
public class BootAppplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("This is BootApplicationRunner...");
    }
}
