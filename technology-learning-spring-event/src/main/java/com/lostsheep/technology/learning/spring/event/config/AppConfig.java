package com.lostsheep.technology.learning.spring.event.config;

import com.lostsheep.technology.learning.spring.event.listener.EatEventListener;
import com.lostsheep.technology.learning.spring.event.publish.EatEventPublisherWare;
import com.lostsheep.technology.learning.spring.event.task.EatEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>AppConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 11:49.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Configuration
public class AppConfig {

    @Bean
    public ApplicationEvent eatEvent() {
        return new EatEvent(true);
    }

    @Bean
    public ApplicationListener<EatEvent> eatEventListener() {
        return new EatEventListener();
    }

    @Bean
    public ApplicationEventPublisherAware eatEventPublisherWare(ApplicationEvent eatEvent) {
        return new EatEventPublisherWare(eatEvent);
    }
}
