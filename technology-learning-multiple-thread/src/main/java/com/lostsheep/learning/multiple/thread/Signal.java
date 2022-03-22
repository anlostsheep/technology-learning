package com.lostsheep.learning.multiple.thread;

/**
 * <b><code>Signal</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/22
 *
 * @author dengzhen
 * @since technology-learning
 */
public class Signal {

    private static volatile int signal = 0;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 0) {
                    System.out.println(signal);

                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            while (signal < 5) {
                if (signal % 2 == 1) {
                    System.out.println(signal);

                    synchronized (this) {
                        signal = signal + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadA()).start();
        Thread.sleep(3000);
        new Thread(new ThreadB()).start();
    }
}
