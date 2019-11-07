package kitchen.order.merchname;
import java.util.Collections;
import java.util.List;

/**
 * 单品馒头，只有名称List，没有MerchName对象List
 * @author 宋亮
 */
public class SteamedBread implements MerchName {
    /**
     * 商品名称
     */
    public final static List<String> names= Collections.singletonList("馒头");

    /**
     * 获取MerchName对象的List
     * 
     * @return 单品返回null
     */
    @Override
    public List<MerchName> getMerch() {
        return null;
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
