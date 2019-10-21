package Sale.Coffee;

import Price.PriceTable;

/**
 * @className: Milk
 * @author: Shidan Cheng
 * @description: 咖啡加牛奶 具体装饰者类
 * @designPattern: Decorator
 * @date: 12:01 上午 2019/10/22
 */
public class AddMilk extends AddDecorator {

    /**
     * 默认构造器-加牛奶
     *
     * @methodName: AddMilk
     * @param coffee: 需要装饰的咖啡
     * @return:
     */
    public AddMilk(CoffeeMachine coffee) {
        super(coffee);
        this.addMaterial();
    }

    @Override
    public void addMaterial() {
        this.coffee.addMaterial("+牛奶", PriceTable.MATERIAL_MILK);
    }
}