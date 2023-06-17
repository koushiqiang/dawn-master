package com.neutrino.dawn.designmodel.factorymethod.impl;

import com.neutrino.dawn.designmodel.factorymethod.CustomerFactory;
import com.neutrino.dawn.designmodel.simplefactory.Agent;
import com.neutrino.dawn.designmodel.simplefactory.Customer;

/**
 * @Description: 代理商工厂
 * @Date 2022-3-6 , 0006 16:21
 * @Author kousq
 */
public class AgentFactory implements CustomerFactory {

    @Override
    public Customer create(String type, String name) {
        return new Agent(type, name);
    }

}