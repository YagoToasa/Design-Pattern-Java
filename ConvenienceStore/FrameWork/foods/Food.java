package foods;

import foods.state.FoodState;
import foods.state.Normal;
import utils.enums.FoodType;
import utils.info.ConstantTable;
import utils.info.PriceTable;

/**
 * @className: Food
 * @author: Shidan Cheng
 * @description: 食品抽象类
 * @designPattern: Prototype, Proxy
 * @date: 8:48 上午 2019/10/22
 * @version: v1.0
 */
public abstract class Food {
    protected FoodState state;          //食品品质
    protected String name;              //食品名称
    protected String type;              //食品类型
    protected int price;                //食品价格
    protected int remainDays;           //食品距离过期还剩多少天

    public Food(String name, String type){
        this.name = name;
        this.price = PriceTable.FOOD_PRICE_MAP.get(name);
        this.remainDays = ConstantTable.FOOD_SHELF_LIFE_MAP.get(name);
        this.state = new Normal();
        this.type = type;

    }

    /**
     * 返回一个克隆的食品
     *
     * @methodName: createClone
     * @return: foods.Food
     */
    public abstract Food createClone();
}