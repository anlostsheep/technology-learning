package com.lostsheep.technology.learning.async.upload.pipe;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>HBasePipeline</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/11/13.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class HBasePipeline implements Pipeline {

    @Override
    public void send2TargetSource() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("thread error: {}", Thread.currentThread().getName(), e);
        }

        log.info("{} is done source flow!", this.getClass().getCanonicalName());
    }
}
