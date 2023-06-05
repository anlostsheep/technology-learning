package com.lostsheep.learning.multiple.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <b><code>ThreadId</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/18.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ThreadId {
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    public static int get() {
        return threadId.get();
    }
}
