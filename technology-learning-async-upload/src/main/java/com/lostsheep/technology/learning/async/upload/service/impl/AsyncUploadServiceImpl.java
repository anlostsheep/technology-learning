package com.lostsheep.technology.learning.async.upload.service.impl;

import com.alibaba.fastjson.JSON;
import com.lostsheep.technology.learning.async.upload.service.AsyncUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <b><code>AsyncUploadServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/31 23:27.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Slf4j
@Service
public class AsyncUploadServiceImpl implements AsyncUploadService {

    @Async("asyncExecutor")
    @Override
    public void asyncUploadResources(String currentTimeStamp) {
        log.info("上传文件时间:{}", JSON.toJSONString(currentTimeStamp));

        
    }

}
