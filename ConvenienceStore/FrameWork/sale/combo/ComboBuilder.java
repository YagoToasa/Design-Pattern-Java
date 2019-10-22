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
    protected FoodCombo foodCombo;
    protected int reducedPrice;

    public ComboBuilder(FoodCombo foodCombo, int reducedPrice){
        this.foodCombo = foodCombo;
        this.reducedPrice = reducedPrice;
    }

    public void addDrink(){
        System.out.println("抱歉, 该套餐不含饮品!");
    }

    public void addPastry(){
        System.out.println("抱歉, 该套餐不含糕点!");
    }

    public void addSnack(){
        System.out.println("抱歉, 该套餐不含零食!");
    }

    public FoodCombo getFoodCombo() {
        return foodCombo;
    }
}