package com.lostsheep.technology.learning.async.upload.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <b><code>BaseResponse</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/19 22:53.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Data
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -810490629135727977L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    private LocalDateTime responseTime;

    private String message;
}
