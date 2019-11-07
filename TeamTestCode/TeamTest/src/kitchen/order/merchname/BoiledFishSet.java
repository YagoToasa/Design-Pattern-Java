package kitchen.order.merchname;
import java.util.Arrays;
import java.util.List;

/**
 * 水煮鱼套餐，有名称List和MerchName对象List
 * @author 宋亮
 */
public class BoiledFishSet implements MerchName {
    /**
     * 商品名称的List，包含套餐中所有单品的名称
     */
    public final static List<String> names= Arrays.asList("水煮鱼","炒青菜","馒头");

    /**
     * 套餐中所有单品类的List
     */
    public final static List<MerchName> merchs=Arrays.asList(new BoiledFish(),new StirFriedVegetables(),new SteamedBread());

    /**
     * 获取MerchName对象的List
     * 
     * @return 返回MerchName的List
     */
    @Override
    public List<MerchName> getMerch() {
        return merchs;
    }

    /**
     * 获取MerchName对象的名称List
     * 
     * @return 返回商品名的List
     */
    @Override
    public List<String> getMerchName() {
        return names;
    }
}