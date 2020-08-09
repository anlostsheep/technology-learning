package com.lostsheep.learning.multiple.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>ThreadInterrupt</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/5 22:58.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new ThreadOne();
        threadOne.start();
        
        Thread.sleep(200);
        threadOne.interrupt();
        
        threadOne.join();
        
        log.info("main end");
    }
}

@Slf4j
class ThreadOne extends Thread {
    @Override
    public void run() {
        Thread threadTwo = new ThreadTwo();
        threadTwo.start();

        try {
            threadTwo.join();
        } catch (InterruptedException e) {
            log.error("interrupt exception", e);
        }
        
        threadTwo.interrupt();
    }
}

@Slf4j
class ThreadTwo extends Thread {
    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n ++;
            log.info("thread two check {} time", n);

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
