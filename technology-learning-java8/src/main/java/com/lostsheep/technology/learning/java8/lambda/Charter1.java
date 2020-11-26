package com.lostsheep.technology.learning.java8.lambda;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <b><code>Charpter1</code></b>
 * <p/>
 * Description
 * <p/>
 *
 * @author lostsheep
 * @date 2020/11/25
 */
public class Charter1 {

    public static void main(String[] args) {
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        File[] listFiles = new File(".").listFiles(File::isHidden);

        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> collect = number1.stream()
                .flatMap(i -> number2.stream()
                        .map(j -> new int[]{i, j})
                )
                .collect(Collectors.toList());
    }
}
