package com.neutrino.dawn.designmodel.simplefactory;

/**
 * @Description:
 * @Date 2022-3-6 , 0006 16:15
 * @Author kousq
 */
public class CustomerFactory {

    private static Merchant createMerchant(String type, String name) {
        return new Merchant(type, name);
    }

    private static BankPartner createBankPartner(String type, String name) {
        return new BankPartner(type, name);
    }

    private static Agent createAgent(String type, String name) {
        return new Agent(type, name);
    }

    public static Customer create(String type, String name) {
        if ("M".equals(type)) {
            return createMerchant(type, name);
        } else if ("B".equals(type)) {
            return createBankPartner(type, name);
        } else if ("A".equals(type)) {
            return createAgent(type, name);
        }
        return null;
    }

}