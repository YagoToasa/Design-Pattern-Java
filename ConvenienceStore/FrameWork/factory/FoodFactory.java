package factory;

import foods.Drink;
import foods.Food;
import foods.Pastry;
import foods.Snack;
import utils.enums.FoodType;
import utils.info.ConstantTable;

/**
 * @className: FoodFactory
 * @author: Shidan Cheng
 * @description: 食品工厂
 * @designPattern: AbstractFactory, Proxy, Singleton
 * @date: 9:29 上午 2019/10/22
 */
public class FoodFactory extends AbstractFactory {
    private static class FoodFactoryHolder {
        private static final FoodFactory INSTANCE = new FoodFactory();
    }

    private FoodFactory() {

    }

    public static final FoodFactory getInstance() {
        return FoodFactoryHolder.INSTANCE;
    }

    @Override
    public Food createFood(String name) {
        FoodType type = ConstantTable.FOOD_ITEM_TYPE_MAP.get(name);
        if (type == FoodType.Drink) {
            return new Drink(name);
        } else if (type == FoodType.Pastry) {
            return new Pastry(name);
        } else if (type == FoodType.Snack) {
            return new Snack(name);
        }
        return null;
    }


}