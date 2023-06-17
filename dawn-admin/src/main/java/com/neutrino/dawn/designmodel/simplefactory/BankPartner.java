package com.neutrino.dawn.designmodel.simplefactory;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:银行客户
 * @Date 2022-3-6 , 0006 16:14
 * @Author kousq
 */
@Data
@ToString(callSuper = true)
public class BankPartner extends Customer {

    /**
     * 银行编码
     */
    private String code;

    /**
     * 银行地址
     */
    private String address;

    public BankPartner(String name, String type) {
        super(name, type);
    }
}