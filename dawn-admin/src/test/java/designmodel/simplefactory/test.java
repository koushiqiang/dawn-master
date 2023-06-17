package designmodel.simplefactory;

import com.neutrino.dawn.designmodel.simplefactory.Customer;
import com.neutrino.dawn.designmodel.simplefactory.CustomerFactory;
import org.junit.Test;

/**
 * @Description:
 *  * 可以看出简单工厂的使用很简单，就是耦合性太高了。
 *  * 第一，对象和基类之间是基于继承的。
 *  * 第二，工厂类耦合了不同对象的创建，如果对象类型不是固定或者经常变动的，就要频繁修改工厂类，比如我现在要再加一种客户，就必须要改动工厂类，不符开闭原则。
 *  * 所以，简单工厂只适用于固定类型对象的创建。
 * @Date 2022-3-6 , 0006 16:17
 * @Author kousq
 */
public class test {

    @Test
    public static void main(String[] args) {
        Customer merchant = CustomerFactory.create("M", "Java技术栈商户");
        System.out.println(merchant);

        Customer bankPartner = CustomerFactory.create("B", "Java技术栈银行客户");
        System.out.println(bankPartner);

        Customer agent = CustomerFactory.create("A", "Java技术栈代理商");
        System.out.println(agent);
    }

}