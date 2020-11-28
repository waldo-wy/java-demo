package org.waldo.demo.foundation.date;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2018/5/4
 */
public class DateOperator {

    private static final ThreadLocal<SimpleDateFormat> defaultDateFormatter =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    private static SimpleDateFormat UNSAFE_FMT = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws ParseException {
        String sBizDate = "2018-05-18";
        Calendar bizDate = Calendar.getInstance();
        bizDate.setTime(defaultDateFormatter.get().parse(sBizDate));
        System.out.println(bizDate.get(Calendar.DAY_OF_MONTH));

        System.out.println(defaultDateFormatter.get()
                                               .format(DateUtils.addDays(DateUtils.truncate(bizDate.getTime(), Calendar.MONTH), -1)));

        System.out.println(defaultDateFormatter.get().format(DateUtils.addMonths(bizDate.getTime(), -11)));
        System.out.println(defaultDateFormatter.get().format(DateUtils.addDays(bizDate.getTime(), -1)));

        System.out.println(DateUtils.truncate(Calendar.getInstance().getTime(), Calendar.DATE));

//        UNSAFE_FMT.format(new Date());
//        UNSAFE_FMT.format(defaultDateFormatter.get().parse(sBizDate));
    }

}
