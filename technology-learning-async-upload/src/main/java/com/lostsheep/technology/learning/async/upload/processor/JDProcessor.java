package com.lostsheep.technology.learning.async.upload.processor;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>TaobaoProcessor</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class JDProcessor implements Processor {

    public JDProcessor() {
        log.info("实例化 JDProcessor...");
    }

    @Override
    public void process() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("thread error: {}", Thread.currentThread().getName(), e);
        }

        log.info("{} is done process flow!", this.getClass().getCanonicalName());
    }
}
