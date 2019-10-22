import sale.coffee.AddMilk;
import sale.coffee.AddSugar;
import sale.coffee.BasicCoffee;
import sale.coffee.CoffeeMachine;

/**
 * @className: DecoratorDemo
 * @description: 装饰者模式测试程序
 * @author: Shidan Cheng
 * @date: 1:11 上午 2019/10/22
 * @version: v1.0
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("START ========================= Decorator Demo =========================");
        System.out.println("> 顾客: 请做一杯原味咖啡。");
        CoffeeMachine coffeeMix = new BasicCoffee();
        coffeeMix.describeCoffeeInfo();
        System.out.println("> 顾客: 太苦了，请加点糖。");
        coffeeMix = new AddSugar(coffeeMix.getCoffee());
        coffeeMix.describeCoffeeInfo();
        System.out.println("> 顾客: 还是有些苦，请再加点牛奶。");
        coffeeMix = new AddMilk(coffeeMix.getCoffee());
        coffeeMix.describeCoffeeInfo();
        System.out.println("> 顾客: 算了，还是在再加点糖吧！");
        coffeeMix = new AddSugar(coffeeMix.getCoffee());
        coffeeMix.describeCoffeeInfo();
        System.out.println("E N D ========================= Decorator Demo =========================");
    }
}
