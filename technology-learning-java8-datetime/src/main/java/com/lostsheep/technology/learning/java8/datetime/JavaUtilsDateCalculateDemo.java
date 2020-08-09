package com.lostsheep.technology.learning.java8.datetime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * <b><code>JavaUtilsTimeCalculateDemo</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2020/8/8 22:20.
 *
 * @author dengzhen
 * @since technology-learning
 */
public class JavaUtilsDateCalculateDemo {

    public static void main(String[] args) {
        Date date = new Date();
        long dateTime = date.getTime();

        Calendar calendar = Calendar.getInstance();
        calendar.set(1995, 11, 16);

        Date calendarTime = calendar.getTime();
        long calendarTime2 = calendarTime.getTime();

        long day = (dateTime - calendarTime2) / 1000 / 60 / 60 / 24;
        System.out.println("old:" + day);

        long between = ChronoUnit.DAYS.between(LocalDate.of(1995, 12, 16), LocalDate.now());
        System.out.println("new:" + between);
    }
}
