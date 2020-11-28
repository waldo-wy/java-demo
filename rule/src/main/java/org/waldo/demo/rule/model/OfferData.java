package org.waldo.demo.rule.model;

import lombok.Data;
import org.waldo.demo.rule.constants.WarehouseType;

/**
 * TODO 文件描述
 *
 * @author waldo.wy 2019-03-07
 */
@Data
public class OfferData {

    /**
     * 叶子类目
     */
    private Long leafCategoryId;

    /**
     * 仓库类型
     */
    private WarehouseType warehouseType;

    private Long backOfferId;

    private Long brandId;
    

}
