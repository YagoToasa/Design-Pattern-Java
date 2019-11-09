package TestProgramDemo.PatternRealizationDemo;

import java.util.ArrayList;

/**
 * @className: MementoDemo
 * @author: Xian Zhou
 * @description:
 * @date: 10:25 2019/11/9
 * @version: v1.0 版本
 */
public class MementoDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================== Memento Demo ==========================");
        kitchen.order.orderform.Order o = new kitchen.order.orderform.Order();
        o.adddish("麻婆豆腐");
        o.adddish("鸡蛋汤");
        System.out.println("新建订单o，添加菜品麻婆豆腐，鸡蛋汤。");
        o.canceldish("鸡蛋汤");
        System.out.println("删除菜品鸡蛋汤，此时订单菜单有：");
        ArrayList<String> menu = o.givemenu();
        for (String i : menu
        ) {
            System.out.println(i);
        }
        o = kitchen.order.orderform.Memento.getInstance().getBackup(o);
        System.out.println("用Memento模式回到o的上一步历史订单，此时订单菜单有：");
        menu = o.givemenu();
        for (String i : menu
        ) {
            System.out.println(i);
        }
        System.out.println("E N D =========================== Memento Demo ==========================\n");
    }
}

