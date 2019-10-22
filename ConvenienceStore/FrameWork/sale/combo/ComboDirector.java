package sale.combo;

/**
 * @className: ComboDirector
 * @author: Shidan Cheng
 * @description: 套餐 具体Director类
 * @designPattern: Builder
 * @date: 7:51 上午 2019/10/22
 */
public class ComboDirector {
    private ComboBuilder comboBuilder;

    public ComboDirector(ComboBuilder comboBuilder){
        this.comboBuilder = comboBuilder;
    }

    public void makeFoodCombo(){
        comboBuilder.addDrink();
        comboBuilder.addPastry();
        comboBuilder.addSnack();
    }

    public FoodCombo getFoodCombo(){
        return comboBuilder.getFoodCombo();
    }
}