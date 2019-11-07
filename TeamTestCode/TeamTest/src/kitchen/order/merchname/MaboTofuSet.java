package kitchen.order.merchname;

import java.util.Arrays;
import java.util.List;

/**
 * 麻婆豆腐套餐，有名称List和MerchName对象List
 * @author 宋亮
 */
public class MaboTofuSet implements MerchName {
    /**
     * 商品名称的List，包含套餐中所有单品的名称
     */
    public final static List<String> names = Arrays.asList("麻婆豆腐", "鸡蛋汤", "馒头");

    /**
     * 套餐中所有单品类的List
     */
    public final static List<MerchName> merchs = Arrays.asList(new MaboTofu(), new EggSoup(), new SteamedBread());

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