package com.lostsheep.technology.learning.java8.proxy;

import lombok.extern.slf4j.Slf4j;

/**
 * <b><code>ProxyTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/7/25.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class ProxyTest {

    public static void main(String[] args) {
        // 将生成的代理类保存到本地
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Calculator proxyCalculator = CalculatorProxy.getProxy(new CalculatorImpl());
        int result = proxyCalculator.add(1, 1);
        log.info("result:{}", result);
        log.info("proxyClass:{}", proxyCalculator.getClass());
    }
}
