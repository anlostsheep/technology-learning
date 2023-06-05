package com.lostsheep.technology.learning.spring.event.mock.cacheupdate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b><code>CacheUpdatePublisher</code></b>
 * <p/>
 * 缓存更新事件发布
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 14:17.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@Component
public class CacheUpdatePublisher implements CommandLineRunner {

    ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

    private static final AtomicInteger INCREMENTER = new AtomicInteger(0);

    private final ApplicationContext context;

    public CacheUpdatePublisher(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) {
        log.info("缓存更新事件正在发布...");

        executorService.scheduleAtFixedRate(() -> {
            Cache cache = new Cache(this);
            log.info("缓存初始值");

            cache.setKey("frequency");
            cache.setValue(INCREMENTER.getAndAdd(1));

            context.publishEvent(cache);
            log.info("缓存更新:{}", cache);
        }, 0, 3000, TimeUnit.MILLISECONDS);
    }
}
