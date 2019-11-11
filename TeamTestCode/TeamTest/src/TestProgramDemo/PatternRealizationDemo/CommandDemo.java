package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

/**
 * @className: CommandDemo
 * @author: Siqian Wu
 * @description:
 * @date: 11:56 2019-11-11
 * @version: v1.0
 */
public class CommandDemo {
    public static void main(String[] args){
        try {
            System.out.println("START ========================== Command Demo ==========================");
            Chef chef=Chef.getInstance();
            Waiter waiter = Waiter.getInstance();
            waiter.register(chef);
            Order order = new Order();
            order.setDiscount(0.8);
            order.adddish("水煮鱼");
            order.adddish("鸡蛋汤");
            order.adddish("馒头");
            waiter.register(order);
            waiter.serve(order);//把dishes传进Chef的成员变量
            System.out.println("----访问订单----");
            order.accept(waiter);
            System.out.println("--命令模式测试开始--");
            chef.processMerchs(chef.getDishes());
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }
        System.out.println("E N D =========================== Command Demo ===========================\n");
    }
}
