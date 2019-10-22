package foods;

import factory.AbstractFactory;
import factory.FoodFactory;
import utils.enums.FoodType;


/**
 * @className: FoodProxy
 * @author: Shidan Cheng
 * @description: 食品工厂代理类
 * @designPattern: Proxy
 * @date: 8:31 上午 2019/10/22
 */
public class FoodProxy extends AbstractFactory {
    FoodFactory foodFactory;

    public FoodProxy(FoodFactory foodFactory) {
        this.foodFactory = foodFactory;
    }

    @Override
    public Food createFood(String name) {
        return foodFactory.createFood(name);
    }
}