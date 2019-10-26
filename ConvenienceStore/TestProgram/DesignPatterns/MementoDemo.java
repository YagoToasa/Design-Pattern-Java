package DesignPatterns;


import foods.Drink;
import foods.Food;
import foods.FoodRepository;
import store.mementor.Originator;
import store.mementor.DataCareTaker;
import utils.enums.PatternType;
import world.WorldClock;
import java.util.Map;
import DesignPatterns.ObserverDemo;

import static DesignPatterns.ObserverDemo.initFoodPrototype;

/**
 * @className: DesignPatterns. MementoDemo
 * @description: Memento PATTERN TEST
 * @author: Xian Zhou
 * @date: 19:12 下午 2019/10/26
 * @version: v1.1
 */
public class MementoDemo {
    public static void main(String[] args) {
        //备忘录及仓库初始化
        DataCareTaker mMementoCaretaker = new DataCareTaker();
        Originator mOriginator = new Originator();
        Map<String, Food> foodPrototype = initFoodPrototype();
        FoodRepository foodRepository = FoodRepository.getInstance();
        WorldClock worldClock = WorldClock.getInstance();
        foodPrototype.forEach((k, v) -> {
            Food food = v.createClone(PatternType.Observer);
            worldClock.addObserver(food);
            foodRepository.addFood(food);
        });
        System.out.println("START ========================== Memento Demo ==========================");
        //等待调取库存的函数更新后处理成第一个状态，暂用固定数据

        mOriginator.testState1(foodRepository);

        //将当前状态存储到备忘录
        mMementoCaretaker
                .saveMemento("Originator", mOriginator.createMemento());

        //从备忘录里查看当前状态
        mOriginator.showState();

        //第二个状态，库存发生变动后调取当前状态
        Food cola=new Drink("可乐","饮品");
        System.out.println("顾客购买一瓶可乐后");

        for (Food food : foodRepository.getFoodList()) {
            if (food.getName() == "可乐") {
                cola=food;
                break;
            }
        }

        while(foodRepository.removeFood(cola) ){
            mOriginator.testState1(foodRepository);
        }


        //展示当前状态
        mOriginator.showState();


        //顾客要退货，此处等待一个允许顾客退货的函数操作
        System.out.println("顾客退货");
        foodRepository.addFood(cola);

        // 退回之前的状态
        mOriginator.restoreMemento(mMementoCaretaker
                .retrieveMemento("Originator"));

        //展示一下
        mOriginator.showState();
        System.out.println("E N D ========================== Memento Demo ==========================\n");


    }

}

