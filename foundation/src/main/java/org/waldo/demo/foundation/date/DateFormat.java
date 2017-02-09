package org.waldo.demo.foundation.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 类DateFormat的实现描述：TODO 类实现描述
 *
 * @author waldo.wangy 2017/2/7 14:20
 */
public class DateFormat {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("today:" + today);
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")));
//        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmSS")));  throw java.time.temporal.UnsupportedTemporalTypeException: Unsupported field: HourOfDay
        System.out.println(today.format(DateTimeFormatter.BASIC_ISO_DATE));

        LocalDateTime now = LocalDateTime.now();
        System.out.println("now:" + now);
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:SS")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmSS")));
        System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));

        Instant timestamp = Instant.now();
        // default format
        System.out.println("Default format of Instant=" + timestamp);
    }

}
