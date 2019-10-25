package person;

import java.util.*;
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

    ArrayList<ShopAssistant> sa = new ArrayList<ShopAssistant>();

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

    /** @update: 添加了店主招纳新员工的功能 2019/10/25 - Lanxin Liu */
    public void addAssistant(ShopAssistant s) {
        sa.add(s);
        System.out.println("新招募了一位店员["+s.getName()+"]");
    }

    /** @update: 添加了店主开除店员的功能 2019/10/25 - Lanxin Liu */
    public void deleteAssistant(ShopAssistant s) {
        sa.remove(s);
        System.out.println("开除了一位店员["+s.getName()+"]");
    }

    /** @update: 添加了店主向外提供店员名单的功能 2019/10/25 - Lanxin Liu */
    public ArrayList<ShopAssistant> getSAList() {
        return sa;
    }

    /** @update: 添加了店主打印店员名单的功能 2019/10/25 - Lanxin Liu */
    public void printList() {
        System.out.println("店主："+this.getName());
        System.out.println();
        for(ShopAssistant s:sa) {
            System.out.println("店员姓名："+s.getName());
            System.out.println("店员职责："+s.getDuty());
            System.out.println();
        }
    }
}