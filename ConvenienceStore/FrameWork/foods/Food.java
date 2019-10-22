package foods;

import foods.state.FoodState;
import foods.state.Normal;
import utils.enums.PatternType;
import utils.info.PriceTable;

import static utils.info.ConstantTable.FOOD_SHELF_LIFE_MAP;

/**
 * @className: Food
 * @author: Shidan Cheng
 * @description: 食品抽象类
 * @designPattern: Prototype, Proxy, State
 * @date: 8:48 上午 2019/10/22
 * @version: v1.0
 */
public abstract class Food implements Cloneable {
    protected FoodState state;          //食品品质
    protected String name;              //食品名称
    protected String type;              //食品类型
    protected int price;                //食品价格

    public Food(String name, String type) {
        this.name = name;
        this.price = PriceTable.FOOD_PRICE_MAP.get(name);
        this.state = new Normal(FOOD_SHELF_LIFE_MAP.get(name));
        this.type = type;
    }

    /**
     * 返回一个克隆的食品
     *
     * @methodName: createDeepClone
     * @return: foods.Food
     */
    public abstract Food createClone(PatternType patternType);

    /**
     * 辅助方法, 根据不同的模式调整输出克隆文本信息
     *
     * @methodName: createCloneHeader
     * @param patternType: PatternType 模式名称
     * @return: void
     */
    protected void createCloneHeader(PatternType patternType) {
        if (patternType == PatternType.Prototype) {
            System.out.printf(">>> 克隆-食品原型: %s", this.name);
        } else if (patternType == PatternType.Iterator) {
            System.out.printf(">>> 添加-食品: %s", this.name);
        } else {
            System.out.printf(">>> 制作-食品: %s", this.name);
        }
    }

    /**
     * 描述食品的详细信息
     *
     * @methodName: describeFoodInfomation
     * @return: void
     */
    public void describeFoodDetailInformation() {
        float discountPrice = (float) this.price * this.state.getDiscountDependByState();
        System.out.println("食品名称: " + this.name);
        System.out.println("食品类型: " + this.type);
        System.out.println("食品原价: " + this.price + " 元");
        this.state.describePriceAdjustment();
    }

    /**
     * 描述食品的简要信息
     *
     * @methodName: describeFoodBriefInformation
     * @return: void
     */
    public void describeFoodBriefInformation() {
        System.out.printf("食品名称:%-5s\t类型:%-5s\t售价:%d元;\n", this.name, this.type, this.price);
    }


    /**
     * 设置食品的品质状态
     * 测试 State 状态模式的辅助方法
     *
     * @methodName: testStateDesignPattern
     * @param state: FoodState
     * @return: void
     */
    public void setFoodState(FoodState state) {
        this.state = state;
        System.out.println("> 调整食品状态-剩余保质期时间: " + state.getRemainDays());
    }

    /**
     * 设置食品的价格
     *
     * @methodName: setPrice
     * @param price: int
     * @return: void
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 获取食品的价格
     *
     * @methodName: getPrice
     * @return: int
     */
    public int getPrice() {
        return price;
    }

    /**
     * 获取食品名称
     *
     * @methodName: getName
     * @return: String
     */
    public String getName() {
        return name;
    }

    /**
     * 获取食品类型
     *
     * @methodName: getType
     * @return: String
     */
    public String getType() {
        return type;
    }
}