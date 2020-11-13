package com.lostsheep.technology.learning.spring.event.mock.cacheupdate;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * <b><code>Cache</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 14:11.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Setter
@Getter
public class Cache extends ApplicationEvent {
    
    private String key;
    
    private Object value;

    public Cache(Object source) {
        super(source);
    }
}
