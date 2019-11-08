package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

import java.util.ArrayList;

/**
 * @className:
 * @description:
 * @author: anonym_co
 * @date: 23:00 2019/11/08
 * @version: v1.0
 */
public class InterpreterDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        Waiter waiter = Waiter.getInstance();
        Chef chef = Chef.getInstance();
        Order order = new Order();
        order.setDiscount(0.8);
        order.adddish("水煮鱼");
        order.adddish("鸡蛋汤");
        order.adddish("馒头");
        waiter.register(order);
        waiter.register(chef);
        waiter.serve(order);

        System.out.println("START ========================= InterpreterDemo ========================");
        System.out.println("> 访问水煮鱼的价钱：");
        waiter.getDishes().get(0).accept(waiter);
        System.out.print("> ");
        order.accept(waiter);
        System.out.println("E N D ========================= InterpreterDemo ========================\n");
    }
}
