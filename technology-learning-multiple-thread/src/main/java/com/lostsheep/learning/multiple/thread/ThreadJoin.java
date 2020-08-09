package com.lostsheep.learning.multiple.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>ThreadJoin</code></b>
 * <p/>
 * 你好
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 22:49.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyTread();
        log.info("thread start");
        thread.start();
        
        Thread.sleep(1);
        
        thread.interrupt();
        
        thread.join();
        
        log.info("main thread end");

    }

}

@Slf4j
class MyTread extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            log.info("mythread check {} time", n);
        }
    }
}
