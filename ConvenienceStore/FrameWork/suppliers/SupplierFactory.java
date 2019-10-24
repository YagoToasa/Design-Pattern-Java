package suppliers;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: SupplierFactory
 * @author: Yinan Cheng
 * @description: 享元工厂类，管理享元对象（供应商），针对抽象享元类编程
 * @designPattern: Flyweight
 * @date: 14:14 2019/10/24
 */
public class SupplierFactory {
    private static SupplierFactory supplierFactory = new SupplierFactory();
    private Map<String, AbstractSupplier> supplierMap = new HashMap<String, AbstractSupplier>();

    private SupplierFactory() {
        AbstractSupplier supplierA = new SupplierA("A");
        AbstractSupplier supplierB = new SupplierA("B");
        supplierMap.put("A", supplierA);
        supplierMap.put("B", supplierB);
    }

    public static SupplierFactory getThreadFactory() {
        return supplierFactory;
    }

    public AbstractSupplier getSupplier(String supplierName) {
        //如果此次进货的供应商已经在享元池中，则从池中获取
        if (supplierMap.containsKey(supplierName)) {
            return supplierMap.get(supplierName);
        }
        // 如果是新联系的供应商（在享元池中不存在），则new一个
        else {
            NewSupplier supplierNew = new NewSupplier(supplierName);
            supplierMap.put(supplierName, supplierNew);
            return supplierNew;
        }

    }
}
