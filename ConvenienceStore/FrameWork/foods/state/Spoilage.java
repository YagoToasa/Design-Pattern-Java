package foods.state;

/**
 * @className: Spoilage
 * @author: Shidan Cheng
 * @description: 食品变质
 * @designPattern: State
 * @date: 10:36 上午 2019/10/22
 */
public class Spoilage extends FoodState {

    public Spoilage(int remainDays) {
        super("变质", remainDays);
    }

    @Override
    public int getRemainDays() {
        return 0;
    }

    @Override
    public float getDiscountDependByState() {
        return 0f;
    }

    @Override
    public void describePriceAdjustment() {
        System.out.println("食品已过期, 不可出售!");
    }
}