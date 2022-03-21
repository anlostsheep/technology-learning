package com.lostsheep.learning.multiple.thread;

import java.util.concurrent.*;

/**
 * <b><code>Task</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/21
 *
 * @author dengzhen
 * @since technology-learning
 */
public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> future = executorService.submit(task);
        System.out.println(future.get());
        future.cancel(true);
    }
}
