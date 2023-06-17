package com.neutrino.dawn.designmodel.factorymethod.impl;

import com.neutrino.dawn.designmodel.factorymethod.CustomerFactory;
import com.neutrino.dawn.designmodel.simplefactory.Customer;
import com.neutrino.dawn.designmodel.simplefactory.Merchant;

/**
 * @Description: 商户工厂
 * @Date 2022-3-6 , 0006 16:20
 * @Author kousq
 */
public class MerchantFactory implements CustomerFactory {

    @Override
    public Customer create(String type, String name) {
        return new Merchant(type, name);
    }

}