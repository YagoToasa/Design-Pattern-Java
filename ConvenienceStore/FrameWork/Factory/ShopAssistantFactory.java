package Factory;

import Person.ShopAssistant;

import java.util.*;
/**
 * @className: ShopAssistantFactory
 * @description:店员工厂，单例
 * @author: Wenyue Li
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
/**
 * 
 */
public class ShopAssistantFactory extends AbstractFactory {
    private volatile static ShopAssistantFactory singleton=new ShopAssistantFactory();
    //单例模式
    public static ShopAssistantFactory getInstance(){
        return singleton;
    }
    /**
     * @methodName: createShopAssistant
     * @author: Wenyue Li
     * @description: 
     * @date: 1:05 上午 2019/10/22
     * @param [name]
     * @return Person.ShopAssistant
     **/
    @Override
    public ShopAssistant createShopAssistant(String name){
        new ShopAssistant(name);
        return null;
    }
    /**
     * Default constructor
     */
    public ShopAssistantFactory() {
    }

}