import Sale.Coffee.AddMilk;
import Sale.Coffee.AddSugar;
import Sale.Coffee.BasicCoffee;
import Sale.Coffee.CoffeeMachine;

/**
 * @className: DecoratorDemo
 * @description: 装饰者模式测试程序
 * @author: Shidan Cheng
 * @date: 1:11 上午 2019/10/22
 * @version: v1.0
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        CoffeeMachine coffee = new BasicCoffee();
        coffee.describeCoffeeInfo();
        coffee = new AddSugar(coffee.getCoffee());
        coffee.describeCoffeeInfo();
        coffee = new AddMilk(coffee.getCoffee());
        coffee.describeCoffeeInfo();
        coffee = new AddMilk(coffee.getCoffee());
        coffee.describeCoffeeInfo();
    }
}
