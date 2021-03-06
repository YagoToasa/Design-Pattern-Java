package sale.combo;

import foods.Food;
import shopping.ShoppingCart;
import utils.info.ConstantTable;

/**
 * @className: FoodCombo
 * @author: Shidan Cheng
 * @description: 食物套餐
 * @designPattern: Builder
 * @date: 7:59 上午 2019/10/22
 * @version: v1.0
 */
public class FoodCombo {
    private ShoppingCart shoppingCart;

    public FoodCombo() {
        try {
            this.shoppingCart = new ShoppingCart(ConstantTable.FOOD_COMBO_SIZE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addItem(Food food) {
        shoppingCart.addFood(food);
    }
}