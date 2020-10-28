package com.lostsheep.technology.learning.spring.event.publish;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * <b><code>EatEventPublisherWare</code></b>
 * <p/>
 * 事件发布代理
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 11:20.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
public class EatEventPublisherWare implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;
    private final ApplicationEvent applicationEvent;

    public EatEventPublisherWare(ApplicationEvent applicationEvent) {
        this.applicationEvent = applicationEvent;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    /**
     * 发送事件方法, 事件的发送需要主动触发, 调用此方法进行事件触发
     * {@link ApplicationEventPublisher#publishEvent(ApplicationEvent)}
     */
    public void refreshEvent() {
        log.info("发送事件进行中...");

        this.eventPublisher.publishEvent(applicationEvent);
    }
}
