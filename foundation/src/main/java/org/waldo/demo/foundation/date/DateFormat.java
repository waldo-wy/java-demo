package org.waldo.demo.foundation.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * 新的日期格式转换
 *
 * @author waldo.wy 2017/2/7 14:20
 */
public class DateFormat {

    public static void main(String[] args) throws ParseException {
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

        System.out.println(new DateFormat().diffMonths("20180312", "20180327"));
        System.out.println(new DateFormat().diffMonths("20160312", "20180327"));
    }

    public int diffMonths(String firstDate, String secondDate) throws ParseException {
        Objects.requireNonNull(firstDate);
        Objects.requireNonNull(secondDate);

        Date first = new SimpleDateFormat("yyyyMMdd").parse(firstDate);
        Date second = new SimpleDateFormat("yyyyMMdd").parse(secondDate);

        Calendar firstCalendar = Calendar.getInstance();
        firstCalendar.setTime(first);

        Calendar secondCalendar = Calendar.getInstance();
        secondCalendar.setTime(second);

        int diffYears = secondCalendar.get(Calendar.YEAR) - firstCalendar.get(Calendar.YEAR);
        int diffMonths = secondCalendar.get(Calendar.MONTH) - firstCalendar.get(Calendar.MONTH);

        return diffYears * 12 + diffMonths + 1;
    }

}
