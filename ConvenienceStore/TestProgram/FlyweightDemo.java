import suppliers.AbstractSupplier;
import suppliers.SupplierFactory;

/**
 * @className: FlyweightDemo
 * @author: Yinan Cheng
 * @description: Flyweight 享元模式 测试程序
 * @date: 13:40 2019/10/24
 */
public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Flyweight Demo ==========================");
        // 获取享元工厂
        SupplierFactory supplierFactory = SupplierFactory.getThreadFactory();

        AbstractSupplier supplier2 = supplierFactory.getSupplier("B");
        supplier2.setProduct("巧克力");
        supplier2.excute();
        AbstractSupplier supplier1 = supplierFactory.getSupplier("A");
        supplier1.setProduct("可乐");
        supplier1.excute();

        // 将新的供应商加入享元池
        AbstractSupplier supplier3 = supplierFactory.getSupplier("C");
        supplier3.setProduct("三明治");
        supplier3.excute();

        System.out.println("E N D ========================= Flyweight Demo =========================\n");
    }
}
