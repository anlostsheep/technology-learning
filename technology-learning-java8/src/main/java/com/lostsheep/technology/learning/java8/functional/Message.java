package com.lostsheep.technology.learning.java8.functional;

/**
 * <b><code>Message</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/1 10:54.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@FunctionalInterface
public interface Message {

    /**
     * 函数计算
     *
     * @param i i
     * @param j j
     * @return i ? j
     */
    int count(int i, int j);
}
