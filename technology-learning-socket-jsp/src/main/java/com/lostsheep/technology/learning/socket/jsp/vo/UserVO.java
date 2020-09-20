package com.lostsheep.technology.learning.socket.jsp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <b><code>UserVO</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/9/20 05:14.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {

    private Long id;

    private String userName;

    private String address;

    private String phone;

    private String email;
}
