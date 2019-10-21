package Shopping;

import Food.FoodPrototype;

/**
 * @interfaceName: Iterator
 * @author: Shidan Cheng
 * @description: 迭代器抽象类
 * @designMethod: Iterator
 * @date: 10:07 下午 2019/10/21
 */
public abstract interface Iterator {

    public boolean hasNext();
    public FoodPrototype next();
}