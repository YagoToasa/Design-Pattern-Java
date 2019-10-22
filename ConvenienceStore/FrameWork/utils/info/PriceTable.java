package utils.info;

import java.util.HashMap;
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

    public final static Map<String, Integer> FOOD_PRICE_MAP = new HashMap<>();

    static {
        FOOD_PRICE_MAP.put("可乐", 3);
        FOOD_PRICE_MAP.put("雪碧", 3);
        FOOD_PRICE_MAP.put("矿泉水", 2);
    }

}
