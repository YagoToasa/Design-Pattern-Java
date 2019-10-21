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