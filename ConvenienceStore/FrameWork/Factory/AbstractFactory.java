package Factory;

import java.util.*;

import Food.FoodPrototype;
import Person.Customer;
import Person.ShopAssistant;
import Person.ShopKeeper;
import utils.Enum.FoodType;
import utils.Enum.PersonType;
/**
 * @className: AbstractFactory
 * @description:所有工厂的基类
 * @author: Wenyue Li
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
public abstract class AbstractFactory {

    /**
     * @methodName: createPerson
     * @author: Wenyue Li
     * @description: 生成人物
     * @date: 8:39 下午 2019/10/21
     * @param name:
     * @return Person.Person
     **/

    public Customer createCustomer(String name){
        return null;
    }

    public ShopKeeper createShopKeeper(String name){
        return null;
    }

    public ShopAssistant createShopAssistant(String name){
        return null;
    }

    /**
     * @methodName: createFood
     * @author: Wenyue Li
     * @description:  生成食物
     * @date: 8:45 下午 2019/10/21
     * @param [name, type]
     * @return Food.FoodPrototype
     **/
    public FoodPrototype createFood(String name, FoodType type){
        return null;
    }

}