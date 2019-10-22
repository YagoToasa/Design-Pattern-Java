package factory;

import foods.Food;
import person.Customer;
import person.ShopAssistant;
import person.ShopKeeper;
import utils.enums.FoodType;

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
     * @param name: 人物
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
     * @description:  生成食品
     * @date: 8:45 下午 2019/10/21
     * @param name: 食品名称
     * @param type: 食品类型
     * @return Food.FoodPrototype
     **/
    public Food createFood(String name, FoodType type){

        return null;
    }

}