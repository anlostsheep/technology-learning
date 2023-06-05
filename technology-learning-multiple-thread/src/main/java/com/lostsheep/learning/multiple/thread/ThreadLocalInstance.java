package com.lostsheep.learning.multiple.thread;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <b><code>ThreadLocalInstance</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/18.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ThreadLocalInstance {

    private static final ThreadLocal<SimpleDateFormat> SIMPLE_DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"));

    public static String get() {
        return SIMPLE_DATE_FORMAT_THREAD_LOCAL.get().format(Calendar.getInstance().getTime());
    }

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(get());
        runnable.run();

        Runnable runnable2 = () -> System.out.println(get());
        runnable2.run();
    }
}
