package person;

/**
 * @className: CustomerFactory
 * @author: Wenyue Li
 * @description: 顾客工厂
 * @designPattern: Singleton
 * @date: 1:05 上午 2019/10/22
 */
public class CustomerFactory{

    /** @update: 更新了单例模式的实现形式 - Shidan Cheng */
    private static class CustomerFactoryHolder {
        private static final CustomerFactory INSTANCE = new CustomerFactory();
    }

    private CustomerFactory() {
    }

    public static final CustomerFactory getInstance() {
        return CustomerFactoryHolder.INSTANCE;
    }

    public Customer createCustomer(String name) {
        return new Customer(name);
    }

}