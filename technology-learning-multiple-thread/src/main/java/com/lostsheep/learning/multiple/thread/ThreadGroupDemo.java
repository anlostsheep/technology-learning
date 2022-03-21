package com.lostsheep.learning.multiple.thread;

/**
 * <b><code>ThreadGroupDemo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/21
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程组名字:" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("线程名字:" + Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("主线程名字:" + Thread.currentThread().getName());
    }
}
