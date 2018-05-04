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

    public static void main(String[] args) throws ParseException {
        String sBizDate = "2018-05-18";
        Calendar bizDate = Calendar.getInstance();
        bizDate.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(sBizDate));
        System.out.println(bizDate.get(Calendar.DAY_OF_MONTH));

        System.out.println(DateUtils.addDays(DateUtils.truncate(bizDate.getTime(), Calendar.MONTH), -1));
    }

}
