package com.lostsheep.technology.learning.alibaba.coding.standard.collection;

import com.lostsheep.technology.learning.alibaba.coding.standard.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <b><code>Charter1</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/10/30 15:13.
 *
 * @author dengzhen
 * @since technology-learning-multiple-thread 1.0.0
 */
public class Charter1 {

    public static void main(String[] args) {
        List<Pair<String, Double>> list = new ArrayList<>();

        list.add(new Pair<>("version", 10.00D));
        list.add(new Pair<>("version", 20.00D));
        list.add(new Pair<>("version", 30.00D));

        Map<String, Double> collect = list.stream()
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        Charter2 charter2 = new Charter2();
    }
}
