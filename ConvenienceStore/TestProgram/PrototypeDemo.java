import factory.FoodFactory;
import foods.Food;
import foods.FoodProxy;
import utils.enums.PatternType;

import java.util.HashMap;
import java.util.Map;

import static utils.info.ConstantTable.FOOD_ITEM_TYPE_MAP;

/**
 * @className: PrototypeDemo
 * @description: Prototype 原型模式 测试程序
 * @author: Shidan Cheng
 * @date: 1:30 下午 2019/10/22
 * @version: v1.0
 */
public class PrototypeDemo {
    /**
     * 获取食物原型映射表 名称:原型
     * 测试 Prototype 原型模式的辅助方法
     *
     * @methodName: initFoodPrototype
     * @return: Map<String, Food>
     */
    public static Map<String, Food> initFoodPrototype() {
        System.out.println("> 初始化食物原型映射表");
        FoodProxy foodProxy = new FoodProxy(FoodFactory.getInstance());
        Map<String, Food> foodPrototypeMap = new HashMap<>();

        FOOD_ITEM_TYPE_MAP.forEach((k, v) -> {
            foodPrototypeMap.put(k, foodProxy.createFood(k));
        });
        System.out.println("> 初始化食物原型映射表 [Completed]");
        System.out.println("---");
        return foodPrototypeMap;
    }


    public static void main(String[] args) {
        System.out.println("START ========================= Prototype Demo =========================");

        Map<String, Food> foodPrototypeMap = initFoodPrototype();
        System.out.println("> 展示食物原型映射表");
        foodPrototypeMap.forEach((k, v) -> {
            v.describeFoodBriefInformation();
        });
        System.out.println("> 展示食物原型映射表 [Completed]");
        System.out.println("---");

        System.out.println("> 开始基于原型克隆食品");
        Map<String, Food> foodCloned = new HashMap<>();
        foodPrototypeMap.forEach((k, v) -> {
            foodCloned.put(k, v.createClone(PatternType.Prototype));
            System.out.println("[√]");
        });
        System.out.println("> 开始基于原型克隆食品 [Completed]");
        System.out.println("---");

        System.out.println("> 展示克隆食品表");
        foodCloned.forEach((k, v) -> {
            v.describeFoodBriefInformation();
        });
        System.out.println("> 展示克隆食品表 [Completed]");
        System.out.println("---");

        System.out.println("> 改变食物原型的价格 全体涨价10元");
        foodPrototypeMap.forEach((k, v) -> {
            v.setPrice(v.getPrice() + 10);
        });
        System.out.println("> 改变食品原型的价格 [Completed]");
        System.out.println("---");

        System.out.println("> 展示食物原型映射表");
        foodPrototypeMap.forEach((k, v) -> {
            v.describeFoodBriefInformation();
        });
        System.out.println("> 展示食物原型映射表 [Completed]");
        System.out.println("---");

        System.out.println("> 展示克隆食品表");
        foodCloned.forEach((k, v) -> {
            v.describeFoodBriefInformation();
        });
        System.out.println("> 展示克隆食品表 [Completed]");

        System.out.println("E N D ========================= Prototype Demo =========================\n");
    }


}
