package com.lostsheep.learning.multiple.thread;

import java.io.Closeable;
import java.io.IOException;

/**
 * <b><code>ThreadCloseable</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/28 16:01.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class ThreadCloseable extends Thread implements Closeable {

    @Override
    public void run() {

    }

    @Override
    public void close() throws IOException {

    }
}
