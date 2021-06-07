package com.lostsheep.technology.learning.selenium.domain;

import lombok.Getter;

/**
 * <b><code>TypeEnum</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2021/5/18
 *
 * @author dengzhen
 * @since technology-learning-alibaba-coding-standard
 */
@Getter
public enum TypeEnum {

    /**
     * 火狐浏览器
     */
    FIREFOX(1, "火狐浏览器"),
    /**
     * 谷歌浏览器
     */
    CHROME(2, "谷歌浏览器");

    private final Integer type;
    private final String name;

    TypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}
