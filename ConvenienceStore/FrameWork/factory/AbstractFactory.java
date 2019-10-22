package factory;

import foods.Food;
import foods.FoodProxy;
import person.Customer;
import person.ShopAssistant;
import utils.enums.FoodType;

/**
 * @className: AbstractFactory
 * @author: Wenyue Li
 * @description: 所有工厂的基类
 * @designPattern: AbstractFactory
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
public abstract class AbstractFactory {

    /**
     * 生成顾客
     *
     * @methodName: createCustomer
     * @param name: String 姓名
     * @return: person.Customer
     */
    public Customer createCustomer(String name) {
        return null;
    }

    /**
     * 生成店员
     *
     * @methodName: createShopAssistant
     * @param name: String 姓名
     * @return: person.ShopAssistant
     */
    public ShopAssistant createShopAssistant(String name) {
        return null;
    }

    /**
     * 生成食品
     *
     * @methodName: createFood
     * @param name: String 食品名称
     * @return: foods.Food
     */
    public Food createFood(String name) {
        return null;
    }

}