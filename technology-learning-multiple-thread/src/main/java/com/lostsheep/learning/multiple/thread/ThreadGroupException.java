package com.lostsheep.learning.multiple.thread;

/**
 * <b><code>ThreadGroupException</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/22
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ThreadGroupException {

    public static void main(String[] args) {
        ThreadGroup threadGroup = new ThreadGroup("group") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " has a exception: " + e.getMessage());
            }
        };

        Thread testThread = new Thread(threadGroup, () -> {
            System.out.println("测试线程");
            throw new RuntimeException("线程测试异常");
        });

        testThread.start();
    }
}
