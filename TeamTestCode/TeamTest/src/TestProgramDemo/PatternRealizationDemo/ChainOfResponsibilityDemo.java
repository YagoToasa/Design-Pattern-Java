package TeamTestCode.TeamTest.src.TestProgramDemo.PatternRealizationDemo;
import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.chef.Chef;
/**
 * @className: ChainOfResponsibilityDemo
 * @description:
 * @author: Wenyue Li
 * @date: 9:18 下午 2019/11/9
 * @version: v1.0
 */
public class ChainOfResponsibilityDemo {
    /**
     * 责任链模式测试
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================= Chain Of Responsibility Demo =========================\n");
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
        System.out.println("--责任链模式测试开始--");
        chef.processMerchs(chef.getDishes());
        System.out.println("--责任链模式测试结束--");
        System.out.println("E N D ========================= Chain Of Responsibility Demo =========================\n");
    }
}
