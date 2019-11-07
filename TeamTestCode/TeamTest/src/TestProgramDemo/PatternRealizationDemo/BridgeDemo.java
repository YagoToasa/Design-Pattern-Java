package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

/**
 * @className: BridgeDemo
 * @author: Shidan Cheng
 * @description:
 * @date: 1:13 下午 2019/11/7
 * @version: v1.0
 */
public class BridgeDemo {
    public static void main(String[] args) {
        try {
            System.out.println("START =========================== Bridge Demo ==========================");
            Chef chef=Chef.getInstance();
            Waiter waiter = Waiter.getInstance();
            waiter.register(chef);
            Order order = new Order();
            order.setDiscount(0.75);
            order.adddish("水煮鱼");
            order.adddish("麻婆豆腐");
            waiter.register(order);
            waiter.serve(order);
            System.out.println("@>>> 桥接模式测试开始");
            waiter.visit(order);
            System.out.println("@>>> 桥接模式测试完成[Completed]");
            System.out.println("E N D =========================== Bridge Demo ==========================\n");
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }

    }
}
