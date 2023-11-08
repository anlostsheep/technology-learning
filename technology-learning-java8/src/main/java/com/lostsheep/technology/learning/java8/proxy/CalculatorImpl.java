package com.lostsheep.technology.learning.java8.proxy;

/**
 * <b><code>CalculatorImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/7/25.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int a, int b) {
        return Math.addExact(a, b);
    }
}
