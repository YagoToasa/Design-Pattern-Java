package Person;
import utils.Enum.PersonType;
import java.util.*;
/**
 * @className: ShopKeeper
 * @description:生成一个店主，单例
 * @author: Wenyue Li
 * @date: 8:42 下午 2019/10/21
 * @version: v1.0
 */
/**
 * 
 */
public class ShopKeeper extends Person {
    private volatile static ShopKeeper singleton = new ShopKeeper();
    //单例
    /**
     * Default constructor
     */
    public ShopKeeper() {
        setName("name");
        setType(PersonType.ShopKeeper);
    }
    /**
     * @methodName: getInstance
     * @author: Wenyue Li
     * @description: 
     * @date: 12:41 上午 2019/10/22
     * @param []
     * @return Person.ShopKeeper
     **/
    public static ShopKeeper getInstance(){
        return singleton;
    }
    /**
     * @methodName: changeShopKeeperName
     * @author: Wenyue Li
     * @description: 为店主改名，其实就是创建个店主，打印店主名，表示已经生成
     * @date: 12:10 上午 2019/10/22
     * @param [name]
     * @return void
     **/
    public void changeShopKeeperName(String name){
        setName(name);
        System.out.print("当前店主为："+ name);
    }

}