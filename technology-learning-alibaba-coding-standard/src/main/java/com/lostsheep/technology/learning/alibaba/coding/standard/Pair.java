package com.lostsheep.technology.learning.alibaba.coding.standard;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <b><code>Pair</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/30 15:14.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pair<T, E> {

    private T key;
    private E value;
}
