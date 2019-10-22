package utils.info;

import utils.enums.FoodType;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: ConstantTable
 * @description: 便利店项目常量条目表(不包含价格条目)
 * @author: Shidan Cheng
 * @date: 8:14 上午 2019/10/22
 * @version: v1.0
 */
public class ConstantTable {
    public final static int SHOPPING_CART_DEFAULT_SIZE = 5;

    public final static Map<String, Integer> FOOD_SHELF_LIFE_MAP = new HashMap<>();
    public final static Map<String, FoodType> FOOD_ITEM_TYPE_MAP = new HashMap<>();

    static {
        //Drink
        FOOD_ITEM_TYPE_MAP.put("可乐",FoodType.Drink);
        FOOD_ITEM_TYPE_MAP.put("雪碧",FoodType.Drink);
        FOOD_ITEM_TYPE_MAP.put("矿泉水",FoodType.Drink);

        FOOD_SHELF_LIFE_MAP.put("可乐", 20);
        FOOD_SHELF_LIFE_MAP.put("雪碧", 20);
        FOOD_SHELF_LIFE_MAP.put("矿泉水", 20);
        //Snack
        FOOD_ITEM_TYPE_MAP.put("巧克力",FoodType.Snack);
        FOOD_ITEM_TYPE_MAP.put("饼干",FoodType.Snack);
        FOOD_ITEM_TYPE_MAP.put("薯片",FoodType.Snack);

        FOOD_SHELF_LIFE_MAP.put("巧克力", 25);
        FOOD_SHELF_LIFE_MAP.put("饼干", 15);
        FOOD_SHELF_LIFE_MAP.put("薯片", 20);
        //Pastry
        FOOD_ITEM_TYPE_MAP.put("蛋挞",FoodType.Pastry);
        FOOD_ITEM_TYPE_MAP.put("饭团",FoodType.Pastry);
        FOOD_ITEM_TYPE_MAP.put("蛋黄酥",FoodType.Pastry);

        FOOD_SHELF_LIFE_MAP.put("蛋挞", 3);
        FOOD_SHELF_LIFE_MAP.put("饭团", 3);
        FOOD_SHELF_LIFE_MAP.put("蛋黄酥", 5);
    }
}
