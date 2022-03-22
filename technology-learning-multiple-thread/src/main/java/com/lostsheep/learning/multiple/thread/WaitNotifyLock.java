package com.lostsheep.learning.multiple.thread;

/**
 * <b><code>WaitNotifyLock</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/22
 *
 * @author dengzhen
 * @since technology-learning
 */
public class WaitNotifyLock {

    static Object lock = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("ThreadA: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    try {
                        System.out.println("ThreadB: " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                lock.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(5000);
        new Thread(new ThreadB()).start();
    }
}
