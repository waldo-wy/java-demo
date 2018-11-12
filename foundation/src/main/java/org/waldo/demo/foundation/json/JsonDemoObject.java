package org.waldo.demo.foundation.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 类JsonDemoObject的实现描述：TODO 类实现描述
 *
 * @author waldo.wy 2018/1/24
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonDemoObject {

    /**
     * 数据统计时间
     */
    @JsonProperty(value = "bizDate", required = true)
    @JSONField(name = "bizDate")
    private String bizDate;

    /**
     * 动销拍档数量
     */
    @JsonProperty(value = "sales_partner_count", required = true)
    @JSONField(name = "sales_partner_count")
    private Long salesPartnerCount;

    /**
     * 动销门店数量
     */
    @JsonProperty(value = "trading_store_count", required = true)
    @JSONField(name = "trading_store_count")
    private Long tradingStoreCount;

    private Boolean reached;

    private boolean isTest;

//    @Data
    private boolean valid;

//    @JsonRawValue
    private String nothing;

    public String getBizDate() {
        return bizDate;
    }

    public void setBizDate(String bizDate) {
        this.bizDate = bizDate;
    }

    public Long getSalesPartnerCount() {
        return salesPartnerCount;
    }

    public void setSalesPartnerCount(Long salesPartnerCount) {
        this.salesPartnerCount = salesPartnerCount;
    }

    public Long getTradingStoreCount() {
        return tradingStoreCount;
    }

    public void setTradingStoreCount(Long tradingStoreCount) {
        this.tradingStoreCount = tradingStoreCount;
    }

    public Boolean getReached() {
        return reached;
    }

    public void setReached(Boolean reached) {
        this.reached = reached;
    }

    public String getNothing() {
        return nothing;
    }

    public void setNothing(String nothing) {
        this.nothing = nothing;
    }

    public Object getNoProperty() {
        return tradingStoreCount;
    }

    @JsonProperty(value = "isTest")
    public boolean isTest() {
        return isTest;
    }

    @JsonProperty(value = "isTest")
    public void setTest(boolean test) {
        isTest = test;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
