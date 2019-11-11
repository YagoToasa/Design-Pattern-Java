package TestProgramDemo.PatternRealizationDemo;
import kitchen.order.orderform.Order;
/**
 * @className: PrototypeDemo
 * @description:
 * @author: Wenyue Li
 * @date: 9:16 下午 2019/11/9
 * @version: v1.0
 */
public class PrototypeDemo {
    /**
     *原型模式
     */
    public static void main(String[] args){
        try {
            System.out.println("START ========================= Prototype Demo =========================\n");
            Order o = new Order();
            System.out.println("o订单的生成使用了Order类的构造器");
            o.adddish("麻婆豆腐");
            System.out.println("为订单o中添加菜”麻婆豆腐“。");
            Order o_copy = (Order) o.clone();
            System.out.println("o_copy订单的生成使用了o的clone()方法。");
            System.out.println("测试o和o_copy的菜单是否相同? " + (o.givemenu().equals(o_copy.givemenu())));
            System.out.println("测试o和o_copy是否相同? " + (o.equals(o_copy)));
            System.out.println("E N D ========================= Prototype Demo =========================\n");
        }catch (Exception e){
            System.out.println("[ERROR]操作错误！");
        }
    }
}
