package com.lostsheep.technology.learning.async.upload.processor;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>DyProcessor</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class DyProcessor implements Processor {

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