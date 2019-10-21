package Sale.Coffee;

import Price.PriceTable;

/**
 * @className: SimpleCoffee
 * @author: Shidan Cheng
 * @description: 苦咖啡 具体构件类
 * @designPattern: Decorator
 * @date: 12:02 上午 2019/10/22
 */
public class BasicCoffee implements CoffeeMachine {

    private int price;                              //价格
    private String material;                        //配料

    public BasicCoffee() {
        this.price = PriceTable.COFFEE;
        this.material = "";
    }

    @Override
    public int getCoffeePrice() {
        return this.price;
    }

    @Override
    public void describeCoffeeInfo() {
        System.out.println("制作成功: 咖啡[基础] * 1, 价格 = " + this.price + " 元");
    }

    @Override
    public CoffeeMachine getCoffee() {
        return this;
    }

    @Override
    public void addMaterial(String item, int price) {
        material += item;
        this.price += price;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}