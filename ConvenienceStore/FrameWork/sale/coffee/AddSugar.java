package sale.coffee;

import utils.info.PriceTable;

/**
 * @className: Sugar
 * @author: Shidan Cheng
 * @description: 咖啡+糖 具体装饰者类
 * @designPattern: Decorator
 * @date: 12:05 上午 2019/10/22
 */
public class AddSugar extends AddDecorator {

    /**
     * 默认构造器-加糖
     *
     * @methodName: AddSugar
     * @param coffee: 需要装饰的咖啡
     */
    public AddSugar(CoffeeMachine coffee) {
        super(coffee);
        this.addMaterial();
    }

    @Override
    public void addMaterial() {
        this.coffee.addMaterial("+糖", PriceTable.MATERIAL_SUGAR);
    }
}