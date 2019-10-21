package Sale.Coffee;

/**
 * @interfaceName: CoffeeMachine
 * @author: Shidan Cheng
 * @description: 咖啡机 抽象构件类
 * @designPattern: Decorator
 * @date: 11:57 下午 2019/10/21
 */
public interface CoffeeMachine {

    /**
     * 获取咖啡
     *
     * @methodName: getCoffee
     * @return: Sale.Coffee.CoffeeMachine
     */
    public CoffeeMachine getCoffee();

    /**
     * 获取咖啡价格
     *
     * @methodName: getCoffeePrice
     * @return: int
     */
    public int getCoffeePrice();

    /**
     * 描述咖啡信息
     *
     * @methodName: describeCoffeeInfo
     * @return: void
     */
    public void describeCoffeeInfo();

    /**
     * 添加配料
     *
     * @methodName: addMaterial
     * @param: [item, price]
     * @return: void
     */
    public void addMaterial(String item, int price);

    /**
     * 获取配料信息
     *
     * @methodName: getMaterial
     * @return: java.lang.String
     */
    public String getMaterial();
}