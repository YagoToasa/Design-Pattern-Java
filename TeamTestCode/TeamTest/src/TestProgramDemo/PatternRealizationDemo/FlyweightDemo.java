package TestProgramDemo.PatternRealizationDemo;

/**
 * @className: FlyweightDemo
 * @author: Xian Zhou
 * @description:
 * @date: 10:25 2019/11/9
 * @version: v1.0 版本
 */
public class FlyweightDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================== Flyweight Demo ==========================");
        kitchen.order.orderform.Order o1 = new kitchen.order.orderform.Order();
        kitchen.order.orderform.Order o2 = new kitchen.order.orderform.Order();
        o1.adddish("鸡蛋汤");
        o2.adddish("鸡蛋汤");
        System.out.println("创建o1,o2两个订单，都添加菜品”鸡蛋汤”。");
        System.out.println("测试o1的历史是否等于o2? " + (kitchen.order.orderform.Memento.getInstance().getBackup(o1).getOid() == kitchen.order.orderform.Memento.getInstance().getBackup(o2).getOid()));
        kitchen.order.orderform.Order o3 = (kitchen.order.orderform.Order)o1.clone();
        o1.canceldish("鸡蛋汤");
        System.out.println("对o1进行操作后，测试此时o1的历史是否等于原o1的历史? " + (kitchen.order.orderform.Memento.getInstance().getBackup(o1).getOid() == o3.getOid()));
        System.out.println("E N D ========================== Flyweight Demo ==========================");

    }

}
