package Sale.Coffee;

import Price.PriceTable;

/**
 * @className: Sugar
 * @author: Shidan Cheng
 * @description: 咖啡+糖 具体装饰者类
 * @designPattern: Decorator
 * @date: 12:05 上午 2019/10/22
 */
public class AddSugar extends AddDecorator {

    public AddSugar(CoffeeMachine coffee) {
        this.coffee = coffee;
        this.addMaterial();
    }

    @Override
    public void addMaterial() {
        this.coffee.addMaterial("+糖", PriceTable.MATERIAL_SUGAR);
    }
}