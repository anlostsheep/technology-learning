package com.lostsheep.technology.learning.async.upload.service;

import org.springframework.web.context.request.async.DeferredResult;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <b><code>BaseService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/19 22:44.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public interface BaseService<T, R> {

    /**
     * 处理有参数有返回值的业务
     *
     * @param t        参数
     * @param function 业务方法
     * @return 返回值
     */
    DeferredResult<R> processService(T t, Function<T, R> function);

    /**
     * 处理无参数有返回值的业务
     *
     * @param supplier 业务方法
     * @return 返回值
     */
    DeferredResult<R> processService(Supplier<R> supplier);

    /**
     * 处理有参数无返回值的业务
     *
     * @param t        参数
     * @param consumer 业务方法
     */
    void processService(T t, Consumer<T> consumer);

}
