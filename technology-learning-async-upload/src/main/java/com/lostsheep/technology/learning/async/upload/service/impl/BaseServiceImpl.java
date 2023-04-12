package com.lostsheep.technology.learning.async.upload.service.impl;

import com.alibaba.fastjson.JSON;
import com.lostsheep.technology.learning.async.upload.domain.BaseRequest;
import com.lostsheep.technology.learning.async.upload.domain.BaseResponse;
import com.lostsheep.technology.learning.async.upload.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * <b><code>BaseServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/19 22:50.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Slf4j
@Service
public class BaseServiceImpl implements BaseService<BaseRequest, BaseResponse> {

    private final ThreadPoolTaskExecutor executor;

    public BaseServiceImpl(@Qualifier("asyncExecutor") ThreadPoolTaskExecutor executor) {
        this.executor = executor;
    }

    @Override
    public DeferredResult<BaseResponse> processService(BaseRequest request,
                                                       Function<BaseRequest, BaseResponse> function) {
        DeferredResult<BaseResponse> result = new DeferredResult<>(8000L);
        result.onTimeout(() -> result.setErrorResult(buildTimeout()));

        executor.submit(() -> {
            try {
                result.setResult(function.apply(request));
            } catch (Exception e) {
                log.error("请求[{}]处理出现异常", JSON.toJSON(request), e);
                result.setResult(buildError());
            }
        });

        return result;
    }

    @Override
    public DeferredResult<BaseResponse> processService(Supplier<BaseResponse> supplier) {
        DeferredResult<BaseResponse> result = new DeferredResult<>(5000L);
        result.onTimeout(() -> result.setErrorResult(buildTimeout()));

        CompletableFuture<BaseResponse> future = CompletableFuture.supplyAsync(supplier, executor)
                .exceptionally(throwable -> {
                    log.error("请求处理异常", throwable);
                    return buildError();
                });

        future.thenAcceptAsync((result::setResult));

        return result;
    }

    @Override
    public void processService(BaseRequest request, Consumer<BaseRequest> consumer) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> consumer.accept(request), executor)
                .exceptionally(throwable -> {
                    log.error("请求处理异常", throwable);
                    return null;
                });

        CompletableFuture.runAsync(() -> consumer.accept(request))
                .exceptionally(throwable -> {
                    log.error("处理异常, 异常线程类:{}", Thread.currentThread().getName(), throwable);
                    return null;
                });
    }

    private BaseResponse buildError() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("request process error");
        baseResponse.setResponseTime(LocalDateTime.now());
        return baseResponse;

    }

    private BaseResponse buildTimeout() {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("request time out");
        baseResponse.setResponseTime(LocalDateTime.now());
        return baseResponse;
    }
}
