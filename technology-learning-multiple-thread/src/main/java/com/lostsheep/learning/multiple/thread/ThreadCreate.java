package com.lostsheep.learning.multiple.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>ThreadCreate</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 22:22.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
public class ThreadCreate {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> log.info("thread start"));
        thread1.setName("thread-%d");
        thread1.start();
        thread1.join();
        log.info("main thread end");
    }
}
