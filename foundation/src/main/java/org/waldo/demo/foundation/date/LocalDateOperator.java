package org.waldo.demo.foundation.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/iso/period.html
 *
 * @author waldo.wy 2019-03-26
 */
public class LocalDateOperator {

    private static DateTimeFormatter DAY_BATCH_FMT = DateTimeFormatter.ofPattern("yyyyMMdd000100");

    public static void main(String[] args) {
        LocalDate nextDay = LocalDate.now().plusDays(1);
        System.out.println(nextDay.format(DAY_BATCH_FMT));
        System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()).format(DAY_BATCH_FMT));

        System.out.println(LocalDateTime.now().plusDays(1).with(LocalTime.MAX));

        LocalDateTime toDateTime = LocalDateTime.of(2019, 7, 2, 12, 27, 45);
        LocalDateTime fromDateTime = LocalDateTime.of(2019, 7, 2, 11, 45, 55);

        System.out.println(ChronoUnit.MINUTES.between(fromDateTime, toDateTime));
    }

}
