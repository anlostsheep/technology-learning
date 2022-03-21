package com.lostsheep.learning.multiple.thread;

import java.util.concurrent.*;

/**
 * <b><code>TaskFuture</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/21
 *
 * @author dengzhen
 * @since technology-learning
 */
public class TaskFuture implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(new TaskFuture());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }
}
