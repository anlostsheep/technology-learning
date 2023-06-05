package com.lostsheep.technology.learning.async.upload.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <b><code>BaseRequest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/19 22:51.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest implements Serializable {

    private static final long serialVersionUID = -538357145232846298L;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GTM+8")
    protected LocalDateTime requestTime;

    protected String requestBody;
}
