package org.waldo.demo.foundation.json;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * 类JsonConstants的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2018/1/24
 */
public class JsonConstants {

    public static final String JSON_RAW_TEXT = "{\"bizDate\": \"2018-01-23\", \"sales_partner_count\": 5125, \"trading_store_count\": 341579, \"reached\": \"Y\"}";

    public static final JsonDemoObject jsonDemoObject;

    static {
        jsonDemoObject = new JsonDemoObject();
        jsonDemoObject.setBizDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        jsonDemoObject.setSalesPartnerCount(5000L);
        jsonDemoObject.setTradingStoreCount(800000L);
//        jsonDemoObject.setReached(Boolean.TRUE);
    }
}
