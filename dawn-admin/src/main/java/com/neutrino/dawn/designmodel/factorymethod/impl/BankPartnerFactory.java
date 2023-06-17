package com.neutrino.dawn.designmodel.factorymethod.impl;

import com.neutrino.dawn.designmodel.factorymethod.CustomerFactory;
import com.neutrino.dawn.designmodel.simplefactory.BankPartner;
import com.neutrino.dawn.designmodel.simplefactory.Customer;

/**
 * @Description: 银行客户工厂
 * @Date 2022-3-6 , 0006 16:21
 * @Author kousq
 */
public class BankPartnerFactory implements CustomerFactory {

    @Override
    public Customer create(String type, String name) {
        return new BankPartner(type, name);
    }

}