package com.lostsheep.technology.learning.socket.jsp.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <b><code>ThreadPoolExecutorConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/20 05:24.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@Configuration
public class ThreadPoolExecutorConfig {

    @Bean("taskExecutor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setDaemon(true)
                .setNameFormat("thread-pool-%d")
                .setUncaughtExceptionHandler((t, e) -> {
                    log.info("线程池内线程[{}]发生异常", t);
                    log.error("线程异常:", e);
                })
                .build();

        executor.setThreadFactory(threadFactory);
        executor.setCorePoolSize(Runtime.getRuntime().availableProcessors());
        executor.setMaxPoolSize(2 * Runtime.getRuntime().availableProcessors() + 1);
        executor.setQueueCapacity(3 * Runtime.getRuntime().availableProcessors());
        executor.setKeepAliveSeconds(60);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        return executor;
    }
}
