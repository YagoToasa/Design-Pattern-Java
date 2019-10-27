package DesignPatterns;

import factory.FoodFactoryA;
import foods.Food;
import foods.FoodProxyA;

import java.util.HashMap;
import java.util.Map;

import static utils.info.ConstantTable.FOOD_ITEM_TYPE_MAP;

/**
 * @className: DesignPatterns.ProxyDemo
 * @description: Proxy 代理模式 测试程序
 * @author: Shidan Cheng
 * @date: 3:29 下午 2019/10/22
 * @version: v1.0
 */
public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Proxy Demo ===========================");
        System.out.println("> 获取食品工厂代理");
        FoodProxyA foodProxyA = new FoodProxyA(FoodFactoryA.getInstance());
        System.out.println("> 获取食品工厂代理 [Completed]");
        System.out.println("---");

        System.out.println("> 通过食品工厂代理制作食品");
        Map<String, Food> foodCreatedMap = new HashMap<>();

        FOOD_ITEM_TYPE_MAP.forEach((k, v) -> {
            System.out.printf(">>> 制作食品:%s",k);
            foodCreatedMap.put(k, foodProxyA.createFood(k));
            System.out.println("[√]");
        });
        System.out.println("> 通过食品工厂代理制作食品 [Completed]");
        System.out.println("---");

        System.out.println("> 展示制作的食品清单");
        foodCreatedMap.forEach((k, v) -> {
            v.describeFoodBriefInformation();
        });
        System.out.println("> 展示制作的食品清单 [Completed]");


        System.out.println("E N D =========================== Proxy Demo ===========================\n");
    }
}
