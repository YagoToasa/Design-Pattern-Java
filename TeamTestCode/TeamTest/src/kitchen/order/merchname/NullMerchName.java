package kitchen.order.merchname;
import java.util.List;

/**
 * 空对象，在用户点到不存在的商品时会创建
 * @author 宋亮
 */
public class NullMerchName implements MerchName {
    /**
     * 获取MerchName对象的List
     * 
     * @return 空对象返回null
     */
    @Override
    public List<MerchName> getMerch() {
        return null;
    }

    /**
     * 获取MerchName对象的名称List
     * 
     * @return 空对象返回null
     */
    @Override
    public List<String> getMerchName() {
        return null;
    }
}
