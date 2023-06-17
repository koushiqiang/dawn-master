package com.neutrino.dawn.designmodel.factorymethod;

import com.neutrino.dawn.designmodel.simplefactory.Customer;

/**
 * @Description: 工厂方法客户接口
 * @Date 2022-3-6 , 0006 16:19
 * @Author kousq
 */
public interface CustomerFactory {
    Customer create(String type, String name);
}
