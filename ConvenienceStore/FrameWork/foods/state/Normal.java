package foods.state;

/**
 * @className: Normal
 * @author: Shidan Cheng
 * @description: 食品正常
 * @designPattern:
 * @date: 10:37 上午 2019/10/22
 */
public class Normal extends FoodState {

    public Normal(int remainDays) {
        super("正常", remainDays);
    }

    @Override
    public int getRemainDays() {
        return this.remainDays;
    }

    @Override
    public float getDiscountDependByState() {
        if (this.getRemainDays() <= 2) {
            return 0.5f;
        }
        return 1f;
    }

    @Override
    public void describePriceAdjustment() {
        int discount = (int) ((1f - this.getDiscountDependByState()) * 100f);
        if (discount != 0) {
            System.out.println("食品折扣: " + discount + "%off");
        }else{
            System.out.println("食品折扣: 无折扣" );
        }
        System.out.println("剩余保质期时间: " + this.remainDays + " 天");
    }


}