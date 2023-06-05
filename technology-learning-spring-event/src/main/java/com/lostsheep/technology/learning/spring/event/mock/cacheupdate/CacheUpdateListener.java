package com.lostsheep.technology.learning.spring.event.mock.cacheupdate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <b><code>CacheUpdateListener</code></b>
 * <p/>
 * 缓存更新事件
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 14:14.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@Component
public class CacheUpdateListener implements ApplicationListener<Cache> {

    private static final Map<String, Object> COUNTER = new ConcurrentHashMap<>();

    @Override
    public void onApplicationEvent(Cache event) {
        log.info("缓存更新事件听到并执行...");

        COUNTER.put(event.getKey(), event.getValue());

        log.info("更新后 counter:{}", COUNTER.toString());
    }
}
