package com.lostsheep.technology.learning.async.upload.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <b><code>UserRequest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2023/6/1.
 *
 * @author dengzhen
 * @since technology-learning
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest extends BaseRequest {

    private String userName;
    private String userAge;
    private String userId;
}
