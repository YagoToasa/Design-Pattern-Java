package sale.coffee;

/**
 * @className: CoffeeDecorator
 * @author: Shidan Cheng
 * @description: 咖啡加配料 抽象装饰者类
 * @designPattern: Decorator
 * @date: 12:00 上午 2019/10/22
 */
public abstract class AddDecorator implements CoffeeMachine {
    protected CoffeeMachine coffee;

    public AddDecorator(CoffeeMachine coffee){
        this.coffee = coffee;
    }

    @Override
    public CoffeeMachine getCoffee() {
        return this.coffee;
    }

    @Override
    public int getCoffeePrice() {
        return this.coffee.getCoffeePrice();
    }

    @Override
    public void describeCoffeeInfo() {
        System.out.println("制作成功: 咖啡[基础" + this.coffee.getMaterial() + "] * 1, 价格 = " + this.coffee.getCoffeePrice() + " 元");
    }

    @Deprecated
    public void addMaterial(String item, int price) {
    }

    @Deprecated
    public String getMaterial() {
        return null;
    }

    /**
     * 抽象方法: 加配料
     *
     * @methodName: addMaterial
     * @return: void
     */
    public abstract void addMaterial();
}