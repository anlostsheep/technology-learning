package com.lostsheep.learning.multiple.thread;

/**
 * <b><code>ObjectLock</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/22
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ObjectLock {

    private static Object lock = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(3000);
        new Thread(new ThreadB()).start();
    }
}
