package com.lostsheep.technology.learning.java8.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * <b><code>ReadChartTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2022/3/28
 *
 * @author dengzhen
 * @since technology-learning
 */
public class ReadChartTest {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/lostsheep/developer/idea/projects/technology-learning/test.dat");
        List<String> lines = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            lines.add(new String(line.getBytes("gbk"), "big5"));
        }

        System.out.println(lines);


        Locale locale = Locale.getDefault();
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());
    }
}
