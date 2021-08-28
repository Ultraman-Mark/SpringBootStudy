package com.pyl.Springboot.study.service;

import com.pyl.Springboot.study.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步服务功能测试
 * Created by PYL
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsymcProcess() throws InterruptedException{
        asyncService.asyncProcess();
        log.info("come in testAsyncProcess...");
    }

    @Test
    public void testasyncProcessHasReturn() throws Exception{
        long start = System.currentTimeMillis();
        Future<Integer> result = asyncService.asyncProcessHasReturn();
        log.info("get async task value: {}",result.get(1, TimeUnit.SECONDS));
        log.info("time epalse for async task : {}ms",System.currentTimeMillis() - start);
    }
}
