package sale.combo;

/**
 * @className: ComboBuilder
 * @author: Shidan Cheng
 * @description: 套餐抽象Builder类
 * @designPattern: Builder
 * @date: 7:52 上午 2019/10/22
 * @version: v1.0
 */
public abstract class ComboBuilder {
    protected FoodCombo foodCombo = new FoodCombo();             //食品套餐
    protected int reducedPrice;                                  //折扣金额
    protected int comboPrice;                                    //套餐总价

    public ComboBuilder(int reducedPrice) {
        this.reducedPrice = reducedPrice;
        this.comboPrice = -reducedPrice;
    }

    public void addDrink() {
        System.out.println("> 抱歉, 该套餐不含饮品!");
    }

    public void addPastry() {
        System.out.println("> 抱歉, 该套餐不含糕点!");
    }

    public void addSnack() {
        System.out.println("> 抱歉, 该套餐不含零食!");
    }

    /**
     * 获取食品套餐
     * 
     * @methodName: getFoodCombo
     * @return: FoodCombo
     */
    public FoodCombo getFoodCombo() {
        return foodCombo;
    }

    /**
     * 获取套餐价格
     *
     * @methodName: getComboPrice
     * @return: int
     */
    public int getComboPrice() {
        return comboPrice;
    }

    /**
     * 获取套餐减免价格
     *
     * @methodName: getReducedPrice
     * @return: int
     */
    public int getReducedPrice() {
        return reducedPrice;
    }
}