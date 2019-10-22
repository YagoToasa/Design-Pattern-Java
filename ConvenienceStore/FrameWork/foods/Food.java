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
 * @designPattern: Prototype, Proxy, State
 * @date: 8:48 上午 2019/10/22
 * @version: v1.0
 */
public abstract class Food {
    protected FoodState state;          //食品品质
    protected String name;              //食品名称
    protected String type;              //食品类型
    protected int price;                //食品价格

    public Food(String name, String type){
        this.name = name;
        this.price = PriceTable.FOOD_PRICE_MAP.get(name);
        this.state = new Normal(ConstantTable.FOOD_SHELF_LIFE_MAP.get(name));
        this.type = type;

    }

    /**
     * 返回一个克隆的食品
     *
     * @methodName: createClone
     * @return: foods.Food
     */
    public abstract Food createClone();

    /**
     * 描述食品的信息
     *
     * @methodName: describeFoodInfomation
     * @return: void
     */
    public void describeFoodInfomation(){
        float discountPrice = (float) this.price * this.state.getDiscountDependByState();
        System.out.println("食品名称: " + this.name);
        System.out.println("食品类型: " + this.type);
        System.out.println("食品原价: " + this.price + " 元");
        this.state.describePriceAdjustment();
    }

    /**
     * 设置食品的品质状态
     * 测试 State 状态模式的辅助方法
     *
     * @methodName: testStateDesignPattern
     * @param state: FoodState
     * @return: void
     */
    public void setFoodState(FoodState state){
        this.state = state;
        System.out.println("> 调整食品状态-剩余保质期时间: " + state.getRemainDays());
    }
}