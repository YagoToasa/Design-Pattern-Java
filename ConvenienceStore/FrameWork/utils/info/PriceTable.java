package utils.info;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @className: PriceList
 * @description: 杂货店价格表
 * @date: 12:11 上午 2019/10/22
 * @version: v1.0
 */
public class PriceTable {
    public final static int COFFEE = 7;
    public final static int MATERIAL_MILK = 3;
    public final static int MATERIAL_SUGAR = 2;

    public final static int A_COMBO_REDUCE_PRICE = 3;
    public final static int B_COMBO_REDUCE_PRICE = 5;

    public final static int ORDINARY_CARD=20;
    public final static int SENIOR_CARD=50;

    public final static Map<String, Integer> FOOD_PRICE_MAP = new HashMap<>();

    static {
        //Drink
        FOOD_PRICE_MAP.put("可乐", 5);
        FOOD_PRICE_MAP.put("雪碧", 4);
        FOOD_PRICE_MAP.put("矿泉水", 2);
        //Snack
        FOOD_PRICE_MAP.put("巧克力", 8);
        FOOD_PRICE_MAP.put("饼干", 5);
        FOOD_PRICE_MAP.put("薯片", 6);
        //Pastry
        FOOD_PRICE_MAP.put("蛋挞", 4);
        FOOD_PRICE_MAP.put("饭团", 3);
        FOOD_PRICE_MAP.put("蛋黄酥", 8);

    }

}
