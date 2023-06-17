package designmodel.factorymethod;

import com.neutrino.dawn.designmodel.factorymethod.CustomerFactory;
import com.neutrino.dawn.designmodel.factorymethod.impl.AgentFactory;
import com.neutrino.dawn.designmodel.factorymethod.impl.BankPartnerFactory;
import com.neutrino.dawn.designmodel.factorymethod.impl.MerchantFactory;
import com.neutrino.dawn.designmodel.simplefactory.Customer;

/**
 * @Description:
 * 工厂方法也是挺简单易用的，耦合性问题也解决了，每增加一个产品就新增一个产品工厂实现类就行了，扩展性非常好。
 * 但也有一个问题，如果产品非常多，那势必会造成工厂实现类泛滥，另外一种可怕的场景就是，如果涉及到工厂接口变更，工厂实现类的维护简直就是一种恶梦。
 * @Date 2022-3-6 , 0006 16:22
 * @Author kousq
 */
public class Test {


    public static void main(String[] args) {
        System.out.println("------工厂模式-工厂方法------");

        CustomerFactory merchantFactory = new MerchantFactory();
        Customer merchant = merchantFactory.create("M", "Java技术栈商户");
        System.out.println(merchant);

        CustomerFactory bankPartnerFactory = new BankPartnerFactory();
        Customer bankPartner = bankPartnerFactory.create("B", "Java技术栈银行客户");
        System.out.println(bankPartner);

        CustomerFactory agentFactory  = new AgentFactory();
        Customer agent = agentFactory.create("A", "Java技术栈代理商");
        System.out.println(agent);
    }

}