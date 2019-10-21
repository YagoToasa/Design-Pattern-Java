package Factory;

import Person.Customer;

import java.util.*;

/**
 * 
 */
public class CustomerFactory extends AbstractFactory {
    private volatile static CustomerFactory singleton=new CustomerFactory();
    //单例模式
    public static CustomerFactory getInstance(){
        return singleton;
    }
    /**
     * @methodName: createCustomer
     * @author: Wenyue Li
     * @description:
     * @date: 1:05 上午 2019/10/22
     * @param name:
     * @return Person.Customer
     **/
    @Override
    public Customer createCustomer(String name){
        new Customer(name);
        return null;
    }
    /**
     * Default constructor
     */
    public CustomerFactory() {
    }

}