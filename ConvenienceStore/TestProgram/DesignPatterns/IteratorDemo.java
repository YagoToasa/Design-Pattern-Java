package DesignPatterns;

import foods.Food;
import shopping.Iterator;
import shopping.ShoppingCart;
import shopping.ShoppingCartIterator;
import utils.enums.PatternType;

import java.util.Map;

/**
 * @className: DesignPatterns.IteratorDemo
 * @description: Iterator 迭代器模式 测试程序
 * @author: Shidan Cheng
 * @date: 11:37 下午 2019/10/21
 * @version: v1.0
 */
public class IteratorDemo {
    public static void main(String[] args) {
        try {
            System.out.println("START ========================= Iterator Demo ==========================");

            Map<String, Food> foodPrototypeMap = PrototypeDemo.initFoodPrototype();

            ShoppingCart shoppingCart = new ShoppingCart(5);
            System.out.println("> 开始向购物车中添加商品");
            shoppingCart.addFood(foodPrototypeMap.get("可乐").createClone(PatternType.Iterator));
            shoppingCart.addFood(foodPrototypeMap.get("蛋黄酥").createClone(PatternType.Iterator));
            shoppingCart.addFood(foodPrototypeMap.get("巧克力").createClone(PatternType.Iterator));
            shoppingCart.addFood(foodPrototypeMap.get("可乐").createClone(PatternType.Iterator));
            shoppingCart.addFood(foodPrototypeMap.get("矿泉水").createClone(PatternType.Iterator));
            shoppingCart.addFood(foodPrototypeMap.get("矿泉水").createClone(PatternType.Iterator));
            System.out.println("> 开始向购物车中添加商品 [Completed]");
            System.out.println("---");

            System.out.println("> 检查购物车中的商品");
            Iterator iterator = new ShoppingCartIterator(shoppingCart);
            while (iterator.hasNext()) {
                iterator.next().describeFoodBriefInformation();
            }
            System.out.println("> 检查购物车中的商品 [Complete]");
            System.out.println("E N D ========================= Iterator Demo ==========================\n");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
