package person;

import utils.enums.PersonType;

/**
 * @className: Customer
 * @author: Wenyue Li
 * @description: 顾客 具体类
 * @designPattern: AbstractFactory
 * @date: 7:09 下午 2019/10/22
 * @version: v1.1
 */
public class Customer extends Person {
    private int expense;

    /** @update: 更新了构造器的形式 - Shidan Cheng */
    public Customer(String name) {
        super(name,PersonType.Customer);
    }

    /** @update: 重载了另一种Customer的构造函数，以处理FilterDemo - Yinan Cheng */
    public Customer(String name,int expense){
        super(name,PersonType.Customer);
        this.expense=expense;
    }

    /** @update: 获得某个客户的年花销 - Yinan Cheng */
    public int getExpense() {
        return expense;
    }
}