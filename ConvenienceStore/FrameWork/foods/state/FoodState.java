package foods.state;

/**
 * @className: FoodState
 * @author: Shidan Cheng
 * @description: 食品状态类
 * @designPattern: State, Prototype
 * @date: 10:33 上午 2019/10/22
 */
public abstract class FoodState implements Cloneable {
    protected String state;             //食品品质
    protected int remainDays;           //食品距离过期的剩余天数

    public FoodState(String state, int remainDays) {
        this.state = state;
        this.remainDays = remainDays;
    }

    /**
     * 调整食品剩余保质天数, 并判断是否需要改变品质信息
     *
     * @methodName: changeTheState
     * @return: boolean
     *          true - 需要调整食品品质状态
     *          false - 不许调整
     */
    public boolean changeTheState() {
        this.remainDays--;
        if (this.remainDays < 0 && this.state.equals("正常")) {
            return true;
        }
        return false;
    }

    /**
     * 获取食品距离过期的剩余天数
     *
     * @methodName: getRemainDays
     * @return: int
     */
    public abstract int getRemainDays();

    /**
     * 获取基于食品状态的折扣比率
     *
     * @methodName: getDiscountDependByState
     * @return: float
     */
    public abstract float getDiscountDependByState();

    /**
     * 描述食品售价调整的信息
     *
     * @methodName: describePriceAdjustment
     * @return: void
     */
    public abstract void describePriceAdjustment();

    @Override
    public FoodState clone() {
        try {
            return (FoodState) super.clone();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}