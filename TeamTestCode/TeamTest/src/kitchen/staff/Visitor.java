package kitchen.staff;
import kitchen.merch.*;
import kitchen.order.orderform.Order;

import java.util.ArrayList;

public interface Visitor {
    /**
     * 访问菜品
     * @param dish 某一菜品
     */
    void visit(Dish dish);

    /**
     * 访问订单
     * @param order 订单
     */
    void visit(Order order);
}
