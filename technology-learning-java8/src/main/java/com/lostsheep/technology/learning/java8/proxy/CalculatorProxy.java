package com.lostsheep.technology.learning.java8.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * <b><code>CalculatorProxy</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/7/25.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Slf4j
public class CalculatorProxy {

    public static Calculator getProxy(Calculator calculator) {
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        Class<?>[] interfaces = calculator.getClass().getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> {
            Object methodResult;
            String methodName = "add";
            if (methodName.equals(method.getName())) {
                log.info("执行 [{}] 方法", methodName);
            }

            methodResult = method.invoke(calculator, args);
            return methodResult;
        };

        return (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
