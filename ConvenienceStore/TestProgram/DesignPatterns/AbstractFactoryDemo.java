package DesignPatterns;

import factory.AbstractFactory;
import factory.FoodFactoryA;
import factory.FoodFactoryB;
import foods.Food;
import utils.info.ConstantTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @className: DesignPatterns.AbstractFactoryDemo
 * @description: AbstractFactory 抽象工厂模式 测试程序
 * @author: Shidan Cheng
 * @date: 6:43 下午 2019/10/22
 * @version: v1.0
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("START ====================== AbstractFactory Demo ======================");
        AbstractFactory foodFactory = FoodFactoryA.getInstance();
        Set<String> nameSet = ConstantTable.FOOD_ITEM_TYPE_MAP.keySet();
        List<Food> foodList = new ArrayList<>();
        System.out.println("> 食品工厂A, 生产食品");
        for (String key : nameSet) {
            Food food = foodFactory.createFood(key);
            System.out.printf(">>> 生成-食品-名称: %s\t类型: %s\t生产方: %s[√]\n",key.toString(),food.getType(),food.getPlace());
            foodList.add(food);
        }
        System.out.println("> 食品工厂A, 生产食品 [Completed]");

        System.out.println("---");

        AbstractFactory foodFactoryB = FoodFactoryB.getInstance();
        System.out.println("> 食品工厂B, 生产食品");
        for (String key : nameSet) {
            Food food = foodFactoryB.createFood(key);
            System.out.printf(">>> 生成-食品-名称: %s\t类型: %s\t生产方: %s[√]\n",key.toString(),food.getType(),food.getPlace());
            foodList.add(food);
        }
        System.out.println("> 食品工厂B, 生产食品 [Completed]");

        System.out.println("E N D ====================== AbstractFactory Demo ======================\n");
    }
}
