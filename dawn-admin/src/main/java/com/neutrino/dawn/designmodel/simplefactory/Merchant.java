package com.neutrino.dawn.designmodel.simplefactory;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:商户
 * @Date 2022-3-6 , 0006 16:13
 * @Author kousq
 */
@Data
@ToString(callSuper = true)
public class Merchant extends Customer {

    /**
     * 合同类型
     */
    private int contractType;

    /**
     * 结算周期（天）
     */
    private int settmentDays;

    public Merchant(String name, String type) {
        super(name, type);
    }
}