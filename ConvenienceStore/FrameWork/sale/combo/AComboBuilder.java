package sale.combo;

import utils.info.PriceTable;

/**
 * @className: AComboBuilder
 * @author: Shidan Cheng
 * @description: A套餐 具体Builder类
 * @designPattern: Builder
 * @date: 7:53 上午 2019/10/22
 * @version: v1.0
 */
public class AComboBuilder extends ComboBuilder {

    public AComboBuilder(FoodCombo foodCombo) {
        super(foodCombo, PriceTable.A_COMBO_REDUCE_PRICE);
    }
}