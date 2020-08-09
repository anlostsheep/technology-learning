package com.lostsheep.technology.learning.binary.tree;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * <b><code>Node</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/7/30 18:08.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
@Data
@Builder
public class Node {

    private String value;

    private Node left;

    private Node right;

    public static void main(String[] args) {
        String str = "abc";
        char[] chars = str.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                Integer count = map.get(c);
                map.put(c, ++count);
            }
            //
            else {
                map.put(c, 1);
            }
        }

        System.out.println(map);
    }

    private static void append(String string) {
        string = string + "htf";
    }
}
