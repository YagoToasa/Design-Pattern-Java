package person;

import utils.enums.PersonType;
import utils.info.ConstantTable;

/**
 * @className: ShopKeeper
 * @description: 店主单例类
 * @author: Wenyue Li
 * @designPattern: AbstractFactory
 * @date: 8:42 下午 2019/10/21
 * @version: v1.1
 */
public class ShopKeeper extends Person {

    /** @update: 更新了此单例类的实现方式 - Shidan Cheng */
    private static class ShopKeeperHolder {
        private static final ShopKeeper INSTANCE = new ShopKeeper();
    }

    private ShopKeeper() {
        super(ConstantTable.SHOP_KEEPER_NAME, PersonType.ShopKeeper);
    }

    public static ShopKeeper getInstance() {
        return ShopKeeperHolder.INSTANCE;
    }
}