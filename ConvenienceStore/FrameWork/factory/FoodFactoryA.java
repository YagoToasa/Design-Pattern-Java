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
 * @description: 食品工厂A
 * @designPattern: Proxy, Singleton, AbstractFactory
 * @date: 9:29 上午 2019/10/22
 */
public class FoodFactoryA implements AbstractFactory {
    private String factoryName = "A工厂";

    private static class FoodFactoryHolder {
        private static final FoodFactoryA INSTANCE = new FoodFactoryA();
    }

    private FoodFactoryA() {

    }

    public static final FoodFactoryA getInstance() {
        return FoodFactoryHolder.INSTANCE;
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