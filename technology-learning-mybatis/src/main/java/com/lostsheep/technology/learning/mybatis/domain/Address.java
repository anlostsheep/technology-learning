package com.lostsheep.technology.learning.mybatis.domain;

import lombok.Data;

/**
 * <b><code>Address</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/5/30 15:06.
 *
 * @author dengzhen
 * @since spring-boot-2x-integration 0.1.0
 */
@Data
public class Address {

    private Long id;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 街道
     */
    private String street;
}
