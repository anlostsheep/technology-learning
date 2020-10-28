package com.lostsheep.technology.learning.spring.event.listener;

import com.lostsheep.technology.learning.spring.event.task.EatEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

import java.util.Optional;

/**
 * <b><code>EatEventListener</code></b>
 * <p/>
 * 事件监听
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 11:41.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
public class EatEventListener implements ApplicationListener<EatEvent> {

    @Override
    public void onApplicationEvent(EatEvent eatEvent) {
        Optional.of(eatEvent)
                .filter(EatEvent::isEatFinished)
                .ifPresent(event -> {
                    event.callParent();
                    log.error("滚犊子!");

                    eatEvent.callFriend();
                    log.error("下次一定!");
                });
    }
}
