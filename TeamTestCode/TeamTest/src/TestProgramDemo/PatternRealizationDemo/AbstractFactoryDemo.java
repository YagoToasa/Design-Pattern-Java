package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

/**
 * @className: AbstractFactoryDemo
 * @description:
 * @author: Yinan Cheng
 * @date: 13:55  2019/11/11
 * @version: v1.0
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Chef chef=Chef.getInstance();
        Waiter waiter = Waiter.getInstance();
        waiter.register(chef);
        Order order = new Order();
        order.setDiscount(0.8);
        order.adddish("水煮鱼");
        order.adddish("鸡蛋汤");
        order.adddish("馒头");
        order.adddish("炒青菜");
        order.adddish("麻婆豆腐");
        waiter.register(order);
        waiter.serve(order);//把dishes传进Chef的成员变量
        System.out.println("----访问订单----");
        order.accept(waiter);
        System.out.println("START ========================= Abstract Factory Demo =========================\n");
        chef.processMerchs(chef.getDishes());
        System.out.println("E N D ========================= Abstract Factory Demo =========================\n");
    }
}
