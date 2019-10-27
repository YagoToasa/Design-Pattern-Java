package suppliers;

/**
 * @className: NewSupplier
 * @author: Yinan Cheng
 * @description: 当联系一个从前没有联系（进过货）的供应商的时候用这个类，继承自AbstractSupplier
 * @designPattern: Flyweight
 * @date: 14:13 2019/10/24
 */
public class NewSupplier extends AbstractSupplier {
    public NewSupplier(String supplierName) {
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
