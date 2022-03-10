package com.lostsheep.technology.learning.java8.clone.serialize;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <b><code>Class</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Class implements Serializable {

    private String name;
    private Integer stuSum;
}
