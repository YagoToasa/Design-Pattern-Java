import factory.FoodFactory;
import foods.Food;
import foods.FoodProxy;
import foods.FoodRepository;
import utils.enums.PatternType;
import world.WorldClock;

import java.util.HashMap;
import java.util.Map;

import static utils.info.ConstantTable.FOOD_ITEM_TYPE_MAP;

/**
 * @className: ObserverDemo
 * @author: Shidan Cheng
 * @description: Observer 观察者模式 测试程序
 * @date: 9:51 下午 2019/10/25
 * @version: v1.0
 */
public class ObserverDemo {
    public static Map<String, Food> initFoodPrototype() {
        System.out.println("> 初始化食物原型映射表");
        FoodProxy foodProxy = new FoodProxy(FoodFactory.getInstance());
        Map<String, Food> foodPrototypeMap = new HashMap<>();

        FOOD_ITEM_TYPE_MAP.forEach((k, v) -> {
            foodPrototypeMap.put(k, foodProxy.createFood(k));
        });
        System.out.println("> 初始化食物原型映射表 [Completed]");
        return foodPrototypeMap;
    }

    public static void main(String[] args) {
        System.out.println("START ========================= Observer Demo ==========================");
        Map<String, Food> foodPrototype = initFoodPrototype();
        System.out.println("> 获取世界时钟单例");
        WorldClock worldClock = WorldClock.getInstance();
        System.out.println("> 当前世界时钟天数为: DAY = " + worldClock.getDay());
        System.out.println("> 获取世界时钟单例 [Completed]");
        System.out.println("> 获取食物仓库单例");
        FoodRepository foodRepository = FoodRepository.getInstance();
        System.out.println("> 获取食物仓库单例 [Completed]");
        System.out.println("> 向食品仓库中添加食品");
        foodPrototype.forEach((k, v) -> {
            Food food = v.createClone(PatternType.Observer);
            worldClock.addObserver(food);
            foodRepository.addFood(food);
        });
        System.out.println("> 向食品仓库中添加食品 [Completed]");
        System.out.println("> 展示食品仓库中的物品信息");
        foodRepository.show();
        System.out.println("> 展示食品仓库中的物品信息 [Completed]");
        System.out.println("---");
        System.out.println("> 世界时钟过了一天，所有的观测者(食品)，更新其保质期");
        worldClock.updateTheWorld();
        System.out.println("> 当前世界时钟天数为: DAY = " + worldClock.getDay());
        foodRepository.show();
        System.out.println("---");
        System.out.println("> 向食品仓库中再次添加食品");
        foodPrototype.forEach((k, v) -> {
            Food food = v.createClone(PatternType.Observer);
            worldClock.addObserver(food);
            foodRepository.addFood(food);
        });
        System.out.println("> 向食品仓库中再次添加食品 [Completed]");
        System.out.println("> 展示食品仓库中的物品信息");
        foodRepository.show();
        System.out.println("> 展示食品仓库中的物品信息 [Completed]");
        System.out.println("---");
        System.out.println("> 世界时钟又过了一天，所有的观测者(食品)，更新其保质期");
        worldClock.updateTheWorld();
        System.out.println("> 当前世界时钟天数为: DAY = " + worldClock.getDay());
        foodRepository.show();
        System.out.println("---");
        System.out.println("> 世界时钟又过了一天，所有的观测者(食品)，更新其保质期");
        worldClock.updateTheWorld();
        System.out.println("> 当前世界时钟天数为: DAY = " + worldClock.getDay());
        foodRepository.show();
        System.out.println("---");
        System.out.println("> 世界时钟又过了一天，所有的观测者(食品)，更新其保质期");
        worldClock.updateTheWorld();
        System.out.println("> 当前世界时钟天数为: DAY = " + worldClock.getDay());
        foodRepository.show();
        System.out.println("E N D ========================= Observer Demo ==========================\n");
    }
}
