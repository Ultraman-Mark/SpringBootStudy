package com.pyl.Springboot.study.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义异步线程池的配置
 * Created by PYL
 */
@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {

    //返回一个自定义的线程池
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程数量
        executor.setCorePoolSize(10);
        //最大线程数量
        executor.setMaxPoolSize(20);
        //缓存队列个数
        executor.setQueueCapacity(20);
        //除核心线程外线程的最大存活时间
        executor.setKeepAliveSeconds(60);
        //线程名前缀
        executor.setThreadNamePrefix("PYLAsync_");

        //是否等待所有线程执行完毕之后关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //等待时长
        executor.setAwaitTerminationSeconds(60);

        //拒绝策略
        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        executor.initialize();

        return executor;
    }

    /**
     * 定义异步任务异常处理类
     * */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandle();
    }

    class AsyncExceptionHandle implements AsyncUncaughtExceptionHandler{

        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AsyncError: {}, Method: {}, Param: {}",
                    throwable.getMessage(),
                    method.getName(),
                    JSON.toJSONString(objects));
            throwable.printStackTrace();

            // TODO 发送邮件，短信
        }
    }
}
