package com.lostsheep.technology.learning.java8.datetime;

import java.time.*;

/**
 * <b><code>JavaUtilTimeDemo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/8 22:54.
 *
 * @author dengzhen
 * @since technology-learning 1.0.0
 */
public class JavaUtilTimeDemo {

    public static void main(String[] args) {
        Instant instant = Instant.now();

        LocalDate localDate = LocalDate.now();

        LocalTime localTime = LocalTime.now();

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDateTime = ZonedDateTime.now();

        System.out.println(instant);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
        System.out.println(zonedDateTime);
    }
}
