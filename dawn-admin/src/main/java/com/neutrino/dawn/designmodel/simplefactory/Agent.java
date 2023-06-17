package com.neutrino.dawn.designmodel.simplefactory;

import lombok.Data;
import lombok.ToString;

/**
 * @Description:代理商
 * @Date 2022-3-6 , 0006 16:15
 * @Author kousq
 */
@Data
@ToString(callSuper = true)
public class Agent extends Customer {

    /**
     * 代理周期
     */
    private int period;

    /**
     * 代理产品
     */
    private int[] products;

    public Agent(String name, String type) {
        super(name, type);
    }
}