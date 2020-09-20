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

    DeferredResult<R> processService(T t, Function<T, R> function);

    DeferredResult<R> processService(Supplier<R> supplier);

    void processService(T t, Consumer<T> consumer);

}
