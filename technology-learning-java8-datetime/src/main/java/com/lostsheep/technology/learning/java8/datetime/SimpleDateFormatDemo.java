package com.lostsheep.technology.learning.java8.datetime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.IntStream;

/**
 * <b><code>SimpleDateFormatDemo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/8 22:33.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
public class SimpleDateFormatDemo {

    static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        IntStream.range(0, 10)
                .forEach(i -> new Thread(() -> {
                    System.out.println(i);
                    try {
                        synchronized (SIMPLE_DATE_FORMAT) {
                            Date date = SIMPLE_DATE_FORMAT.parse("2020-01-01 10:00:00");
                            System.out.println(date);
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }).start());
    }
}
