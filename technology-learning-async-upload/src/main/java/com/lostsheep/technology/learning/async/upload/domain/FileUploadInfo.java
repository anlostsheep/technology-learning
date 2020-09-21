package com.lostsheep.technology.learning.async.upload.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * <b><code>FileUploadInfo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/22 02:29.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class FileUploadInfo extends BaseResponse {

    private static final long serialVersionUID = -2092268671405381056L;

    private List<FileInfo> fileInfos;

}
