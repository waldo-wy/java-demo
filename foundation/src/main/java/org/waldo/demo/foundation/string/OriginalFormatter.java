package org.waldo.demo.foundation.string;

import org.apache.commons.lang3.RegExUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author waldo.wy 2017/8/21
 */
public class OriginalFormatter {

    public static void main(String[] args) {
        int planet = 7;
        long id = 21180330L;
        String event = "a disturbance in the Force";
        List<Long> list = Arrays.asList(1234L, 5678L);

        String messageFormatResult = MessageFormat.format(
                "FMT001: At {1,time} on {1,date}, there was {2}#{0} on planet {0,number,integer}.",
                planet, new Date(), event);
        System.out.println(messageFormatResult);

        String messageFormatResult2 = MessageFormat.format(
                "FMT002: At {1,time} on {1,date}, there was {2} on planet {0,number,integer}. list={3} id={4} {4,number,long} {4,number,integer} {4,number,full} {4,number,#.#}",
                null, new Date(), null, list, id);

        System.out.println(messageFormatResult2);

        String stringFormatResult = String.format("FMT003: At %2$tH:%2$tM:%2$tS on %2$tY-%2$tm-%2$td, there was %3$s on planet %1$d.", planet, new Date(), event);
        System.out.println(stringFormatResult);

        System.out.println(null+"");
//        Map

        StringBuilder temp = new StringBuilder("20190318");
        temp.insert(4, '-');
        temp.insert(7, '-');
        System.out.println(temp.toString());

        System.out.println(RegExUtils.removeAll(MessageFormat.format("id={0} {0,number,long} {0,number,integer} {0,number,full} {0,number,#.#}", id), ","));
    }

}
