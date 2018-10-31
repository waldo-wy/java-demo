package org.waldo.demo.foundation.string;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author waldo.wy 2017/8/21
 */
public class OriginalFormatter {

    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";

        String messageFormatResult = MessageFormat.format(
                "At {1,time} on {1,date}, there was {2} on planet {0,number,integer}.",
                planet, new Date(), event);

        System.out.println(messageFormatResult);

        String stringFormatResult = String.format("At %2$tH:%2$tM:%2$tS on %2$tY-%2$tm-%2$td, there was %3$s on planet %1$d.", planet, new Date(), event);
        System.out.println(stringFormatResult);

        System.out.println(null+"");
//        Map
    }

}
