package com.neutrino.dawn.designmodel.simplefactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Date 2022-3-6 , 0006 16:13
 * @Author kousq
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Customer {

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户类型
     */
    private String type;

}