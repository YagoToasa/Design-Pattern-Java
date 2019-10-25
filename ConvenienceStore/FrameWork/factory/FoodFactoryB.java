package factory;

import foods.Drink;
import foods.Food;
import foods.Pastry;
import foods.Snack;
import utils.enums.FoodType;
import utils.info.ConstantTable;

/**
 * @className: FoodFactoryB
 * @author: Shidan Cheng
 * @description: 食品工厂B
 * @designPattern:  AbstractFactory
 * @date: 8:26 下午 2019/10/25
 * @version: v1.0
 */
public class FoodFactoryB implements AbstractFactory {
    private String factoryName = "B工厂";

    private static class FoodFactoryHolder {
        private static final FoodFactoryB INSTANCE = new FoodFactoryB();
    }

    private FoodFactoryB() {

    }

    public static final FoodFactoryB getInstance() {
        return FoodFactoryB.FoodFactoryHolder.INSTANCE;
    }

    @Override
    public Food createFood(String name) {
        FoodType type = ConstantTable.FOOD_ITEM_TYPE_MAP.get(name);
        if (type == FoodType.Drink) {
            return this.createDrink(name);
        } else if (type == FoodType.Pastry) {
            return this.createPastry(name);
        } else if (type == FoodType.Snack) {
            return this.createSnack(name);
        }
        return null;
    }

    @Override
    public Food createDrink(String name) {
        return new Drink(name, this.factoryName);
    }

    @Override
    public Food createSnack(String name) {
        return new Snack(name, this.factoryName);
    }

    @Override
    public Food createPastry(String name) {
        return new Pastry(name, this.factoryName);
    }

}
