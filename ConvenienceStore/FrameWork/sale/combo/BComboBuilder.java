package sale.combo;

import utils.info.PriceTable;

/**
 * @className: BComboBuilder
 * @author: Shidan Cheng
 * @description: B套餐 具体Builder类
 * @designPattern: Builder
 * @date: 7:53 上午 2019/10/22
 * @version: v1.0
 */
public class BComboBuilder extends ComboBuilder {

    public BComboBuilder(FoodCombo foodCombo) {
        super(foodCombo, PriceTable.B_COMBO_REDUCE_PRICE);
    }

    @Override
    public void addDrink() {

    }

    @Override
    public void addPastry() {

    }

    @Override
    public void addSnack() {

    }
}