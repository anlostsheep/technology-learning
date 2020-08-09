package com.lostsheep.technology.learning.async.upload.service;

/**
 * <b><code>AsyncUploadService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:25.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
public interface AsyncUploadService {

    /**
     * 异步处理资源
     *
     * @param currentTimeStamp 时间戳
     */
    void asyncUploadResources(String currentTimeStamp);
}
