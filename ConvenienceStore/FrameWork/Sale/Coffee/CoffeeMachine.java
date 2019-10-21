package Sale.Coffee;

/**
 * @interfaceName: CoffeeMachine
 * @author: Shidan Cheng
 * @description: 咖啡机 抽象构件类
 * @designPattern: Decorator
 * @date: 11:57 下午 2019/10/21
 */
public interface CoffeeMachine {

    public CoffeeMachine getCoffee();
    public int getCoffeePrice();
    public void describeCoffeeInfo();
    public void addMaterial(String item, int price);
    public String getMaterial();
}