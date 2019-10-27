package suppliers;

/**
 * @className: SupplierB
 * @author: Yinan Cheng
 * @description: 曾经联系过（进过货）的SupplierB,继承自AbstractSupplier
 * @designPattern: Flyweight
 * @date: 14:13 2019/10/24
 */
public class SupplierB extends AbstractSupplier {
    public SupplierB(String supplierName) {
        super(supplierName);
    }

    @Override
    public void excute() {
        System.out.println("Log：此次从 "+supplierName+" 供应商处进货啦，所进货物是"+foodProduct.getName());
    }

    @Override
    public void setProduct(String product) {
        foodProduct= foodProxyA.createFood(product);
    }

//    @Override
//    public void setProduct(String product) {
//        this.product=product;
//    }
}
