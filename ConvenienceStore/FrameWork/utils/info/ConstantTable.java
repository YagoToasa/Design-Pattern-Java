package utils.info;

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

    static {
        FOOD_SHELF_LIFE_MAP.put("可乐", 20);
        FOOD_SHELF_LIFE_MAP.put("雪碧", 20);
        FOOD_SHELF_LIFE_MAP.put("矿泉水", 20);
    }
}
