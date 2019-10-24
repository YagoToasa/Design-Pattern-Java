package suppliers;

/**
 * @className: AbstractSupplier
 * @author: Yinan Cheng
 * @description: 供货商的抽象类，是SupplierA和SupplierB的父类
 * @designPattern: Flyweight
 * @date: 14:12 2019/10/24
 */
public abstract class AbstractSupplier {
    protected String supplierName;
    protected String product;

    public AbstractSupplier(String supplierName) {
        this.supplierName = supplierName;
    }

    public abstract void excute();

    public abstract void setProduct(String product);
}
