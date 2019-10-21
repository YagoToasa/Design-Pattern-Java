package Factory;

import Person.ShopKeeper;

import java.util.*;
/**
 * @className: ShopKeeperFactory
 * @description:店主工厂，单例
 * @author: Wenyue Li
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
public class ShopKeeperFactory extends AbstractFactory {
    private volatile static ShopKeeperFactory singleton = new ShopKeeperFactory();
    //singleton
    /**
     * @methodName: getInstance
     * @author: Wenyue Li
     * @description: 返回店主工厂实例
     * @date: 12:35 上午 2019/10/22
     * @param:
     * @return Factory.ShopKeeperFactory
     **/
    public static ShopKeeperFactory getInstance(){
        return singleton;
    }
    /**
     * @methodName: createShopKeeper
     * @author: Wenyue Li
     * @description: 新店主，并打印店主名
     * @date: 12:43 上午 2019/10/22
     * @param:
     * @return Person.ShopKeeper
     **/
    @Override
    public ShopKeeper createShopKeeper(String name){
        ShopKeeper sk=ShopKeeper.getInstance();
        sk.changeShopKeeperName(name);
        return null;
    }
    /**
     * Default constructor
     */
    public ShopKeeperFactory() {
    }

}