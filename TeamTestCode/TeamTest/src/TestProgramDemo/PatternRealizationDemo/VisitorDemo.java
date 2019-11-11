package TestProgramDemo.PatternRealizationDemo;


import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

/**
 * @className: VisitorDemo
 * @author: Siqian Wu
 * @description:
 * @date: 12:02 2019-11-11
 * @version: v1.0
 */
public class VisitorDemo {
    public static void main(String[] args) {
        try {
            System.out.println("START =========================== Visitor Demo ===========================");
            Waiter waiter = Waiter.getInstance();
            Chef chef = Chef.getInstance();
            Order order = new Order();
            order.setDiscount(0.85);
            order.adddish("水煮鱼");
            order.adddish("鸡蛋汤");
            order.adddish("馒头");
            waiter.register(order);
            waiter.register(chef);
            waiter.serve(order);
            System.out.println("--测试访问者模式--");
            System.out.println("----访问菜品----");
            waiter.getDishes().get(0).accept(waiter);
            System.out.println("----访问订单----");
            order.accept(waiter);
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }
        System.out.println("E N D =========================== Visitor Demo ===========================\n");
    }
}
