package com.lostsheep.technology.learning.async.upload.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <b><code>AsyncConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:18.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    @Bean("asyncExecutor")
    public Executor buildExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("thread-pool-%d")
                .setUncaughtExceptionHandler((t, e) -> {
                    log.info("线程池内线程[{}]发生异常", t);
                    log.error("线程异常:", e);
                })
                .build();

        // 设置线程工厂
        executor.setThreadFactory(threadFactory);
        // 核心线程数大小（CPU 个数乘以 2 + 1）
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        // 最大线程数大小（CPU 个数乘以 10）
        executor.setMaxPoolSize(2 * Runtime.getRuntime().availableProcessors() + 1);
        // 设置线程池中的队列大小
        executor.setQueueCapacity(3 * Runtime.getRuntime().availableProcessors());
        // 设置线程池中线程存活时间/s
        executor.setKeepAliveSeconds(60);
        // 设置线程池队列满时的拒绝策略: CallerRunsPolicy() 不进入线程池中的线程处理,由调用此方法的线程处理
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化线程池
        executor.initialize();

        return executor;
    }
}
