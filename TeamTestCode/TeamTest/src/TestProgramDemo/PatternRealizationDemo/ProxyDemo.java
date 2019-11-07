package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;

/**
 * @className: ProxyDemo
 * @author: Shidan Cheng
 * @description:
 * @date: 1:13 下午 2019/11/7
 * @version: v1.0
 */
public class ProxyDemo {
    public static void main(String[] args) {
        try {
            System.out.println("START =========================== Proxy Demo ===========================");
            System.out.println("> 获取服务员代理单例");
            Waiter waiterProxy = Waiter.getInstance();
            System.out.println("> 获取厨师单例, 并登记");
            Chef chef = Chef.getInstance();
            waiterProxy.register(chef);
            System.out.println("> 顾客开始添加点餐");
            Order order = new Order();
            order.setDiscount(0.8);
            order.adddish("水煮鱼");
            order.adddish("鸡蛋汤");
            order.adddish("馒头");
            System.out.println("@>>> 服务员代理受理顾客订单");
            waiterProxy.register(order);
            System.out.println("@>>> 服务员代理开始处理订单");
            waiterProxy.serve(order);
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }
        System.out.println("E N D =========================== Proxy Demo ===========================\n");
    }
}
