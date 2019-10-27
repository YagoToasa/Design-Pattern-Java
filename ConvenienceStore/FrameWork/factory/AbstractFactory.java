package factory;

import foods.Food;

/**
 * @className: AbstractFactory
 * @author: Wenyue Li
 * @description: 食品工厂的基类
 * @designPattern: AbstractFactory
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
public interface AbstractFactory {

    public abstract Food createFood(String name);
    public abstract Food createDrink(String name);
    public abstract Food createSnack(String name);
    public abstract Food createPastry(String name);

}