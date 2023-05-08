package com.lostsheep.thread;

import com.lostsheep.entity.Task;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <b><code>Broker</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/5/8.
 *
 * @author dengzhen
 * @since technology-learning
 */
public abstract class Broker<T extends Task> {

    public static final LinkedBlockingQueue<Task> LBQ = new LinkedBlockingQueue<>();
    
}
