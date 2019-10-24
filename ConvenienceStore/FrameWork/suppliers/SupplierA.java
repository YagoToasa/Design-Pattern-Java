package suppliers;

/**
 * @className: SupplierA
 * @author: Yinan Cheng
 * @description: 曾经联系过（进过货）的SupplierA,继承自AbstractSupplier
 * @designPattern: Flyweight
 * @date: 14:12 2019/10/24
 */
public class SupplierA extends AbstractSupplier {

    public SupplierA(String supplierName) {
        super(supplierName);
    }

    @Override
    public void excute() {
        System.out.println("Log：此次从 "+supplierName+" 供应商处进货啦，所进货物是"+product);
    }

    @Override
    public void setProduct(String product) {
        this.product=product;
    }
}
