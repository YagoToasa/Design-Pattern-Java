package TestProgramDemo.PatternRealizationDemo;

import kitchen.container.Cabinet;
import kitchen.container.Container;
import kitchen.container.ContainerIterator;
import kitchen.container.Fridge;
import kitchen.ingredient.*;
import kitchen.merch.Adapter;
import kitchen.merch.Dish;
import kitchen.order.merchname.MerchNameFactory;
import kitchen.order.orderform.Memento;
import kitchen.order.orderform.Order;
import kitchen.staff.Waiter;
import kitchen.staff.WaiterInterface;
import kitchen.staff.chef.Chef;
import kitchen.time.Time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @className:
 * @description:
 * @author: anonym_co
 * @date: 18:24 2019/11/08
 * @version: v1.0
 */
public class AdapterWithFacadeDemo {
    public static void main(String[] args) {
        System.out.println("START ================== Adapter Demo & Facade Demo ====================");
        System.out.println("> 顾客点单：水煮鱼、鸡蛋汤、麻婆豆腐、馒头");
        ArrayList<String> list;
        list = new ArrayList<String>();
        list.add("水煮鱼");
        list.add("鸡蛋汤");
        list.add("麻婆豆腐");
        list.add("馒头");
        Waiter waiter = Waiter.getInstance();
        waiter.setLists(list);
        Adapter adapter = new Adapter();
        adapter.getDishes();
        System.out.println("E N D ================== Adapter Demo & Facade Demo ====================\n");
    }
}
