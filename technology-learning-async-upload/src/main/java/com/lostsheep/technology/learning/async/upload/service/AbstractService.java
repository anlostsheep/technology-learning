package com.lostsheep.technology.learning.async.upload.service;

import com.lostsheep.technology.learning.async.upload.domain.BaseRequest;
import com.lostsheep.technology.learning.async.upload.domain.BaseResponse;

/**
 * <b><code>AbstractService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/1.
 *
 * @author dengzhen
 * @since technology-learning
 */
public abstract class AbstractService<T extends BaseRequest, R extends BaseResponse> implements BaseCommonService<T, R> {

    @Override
    public R functionProcess(T t) {
        return null;
    }

    @Override
    public R supplierProcess() {
        return null;
    }

    @Override
    public void consumerProcess(T t) {
    }
}
