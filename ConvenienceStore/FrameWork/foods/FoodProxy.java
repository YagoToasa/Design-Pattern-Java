package foods;

import factory.AbstractFactory;
import factory.FoodFactory;


/**
 * @className: FoodProxy
 * @author: Shidan Cheng
 * @description: 食品工厂代理类
 * @designPattern: Proxy
 * @date: 8:31 上午 2019/10/22
 */
public class FoodProxy implements AbstractFactory {
    FoodFactory foodFactory;

    public FoodProxy(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    @Override
    public Food createFood(String name) {
        return foodFactory.createFood(name);
    }

    @Override
    public Food createDrink(String name) {
        return foodFactory.createDrink(name);
    }

    @Override
    public Food createSnack(String name) {
        return foodFactory.createSnack(name);
    }

    @Override
    public Food createPastry(String name) {
        return foodFactory.createPastry(name);
    }
}