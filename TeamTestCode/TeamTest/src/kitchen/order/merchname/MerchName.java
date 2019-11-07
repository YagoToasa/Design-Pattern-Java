package kitchen.order.merchname;

import java.util.List;

/**
 * 商品名接口，用于实现商品名类，商品名类在客人点单时用到，
 * 其中会包含商品的名称和商品名类的List，在创建订单时，
 * 订单会通过接口获取到商品的名称List
 * @author 宋亮
 */
public interface MerchName {
    /**
     * 获取MerchName对象的List
     */
    public List<String> getMerchName();

    /**
     * 获取MerchName对象的名称List
     */
    public List<MerchName> getMerch();
}