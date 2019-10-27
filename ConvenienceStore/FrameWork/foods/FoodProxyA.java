package foods;

import factory.AbstractFactory;
import factory.FoodFactoryA;


/**
 * @className: FoodProxy
 * @author: Shidan Cheng
 * @description: 食品工厂代理类
 * @designPattern: Proxy
 * @date: 8:31 上午 2019/10/22
 */
public class FoodProxyA implements AbstractFactory {
    FoodFactoryA foodFactoryA;

    public FoodProxyA(FoodFactoryA foodFactoryA) {
        this.foodFactoryA = foodFactoryA;
    }

    @Override
    public Food createFood(String name) {
        return foodFactoryA.createFood(name);
    }

    @Override
    public Food createDrink(String name) {
        return foodFactoryA.createDrink(name);
    }

    @Override
    public Food createSnack(String name) {
        return foodFactoryA.createSnack(name);
    }

    @Override
    public Food createPastry(String name) {
        return foodFactoryA.createPastry(name);
    }
}