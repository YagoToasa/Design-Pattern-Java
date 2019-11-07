package kitchen.staff;

import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;

/**
* 该接口提供两种serve方法为代理模式的抽象主题
* 在真实主题类RealWaiter和代理类Waiter中实现
*/
public interface WaiterInterface {
    void serve(Order order);
    void serve(Chef chef);
}
