package com.lostsheep.technology.learning.async.upload.service;

import com.lostsheep.technology.learning.async.upload.domain.BaseRequest;
import com.lostsheep.technology.learning.async.upload.domain.BaseResponse;

/**
 * <b><code>BaseCommonService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/1.
 *
 * @author dengzhen
 * @since technology-learning
 */
public interface BaseCommonService<T extends BaseRequest, R extends BaseResponse> {

    /**
     * 基础处理方法
     *
     * @param t 请求对象
     * @return 响应对象
     */
    R functionProcess(T t);

    /**
     * 基础处理方法
     *
     * @return 响应对象
     */
    R supplierProcess();

    /**
     * 基础处理方法
     *
     * @param t 请求对象
     */
    void consumerProcess(T t);
}
