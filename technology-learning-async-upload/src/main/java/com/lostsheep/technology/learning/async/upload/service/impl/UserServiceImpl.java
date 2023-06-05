package com.lostsheep.technology.learning.async.upload.service.impl;

import com.lostsheep.technology.learning.async.upload.domain.FileUploadInfo;
import com.lostsheep.technology.learning.async.upload.domain.UserRequest;
import com.lostsheep.technology.learning.async.upload.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <b><code>UserServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/1.
 *
 * @author dengzhen
 * @since technology-learning
 */
@Service
@Slf4j
public class UserServiceImpl extends AbstractService<UserRequest, FileUploadInfo> {

    @Override
    public void consumerProcess(UserRequest userRequest) {
        log.info("req:{}", userRequest);
    }

    @Override
    public FileUploadInfo supplierProcess() {
        return FileUploadInfo.builder().build();
    }
}
