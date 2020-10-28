package com.lostsheep.technology.learning.spring.event;

import com.lostsheep.technology.learning.spring.event.publish.EatEventPublisherWare;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * <b><code>EventTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 11:57.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@SpringBootTest
public class EventTest {

    @Resource
    private EatEventPublisherWare eatEventPublisherWare;

    @Test
    public void testEventPublish() {
        eatEventPublisherWare.refreshEvent();
    }
}
