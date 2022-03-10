package com.lostsheep.technology.learning.java8.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <b><code>Major</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/10
 *
 * @author lostsheep
 * @since technology-learning
 */
@Data
@AllArgsConstructor
public class Major implements Cloneable {

    private String majorName;
    private Integer majorId;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
