package machine;

/**
 * @className: MakeCoffee
 * @description: 制作咖啡
 * @author: Lanxin Liu
 * @designPattern: Template Method
 * @date: 23:59 2019/10/26
 * @version: v1.0
 */
public class MakeCoffee extends MakeDrink {
    @Override
    public void chooseBean() {
        System.out.println("精心挑选出蓝山咖啡豆～");
    }

    @Override
    public void brewBeans() {
        System.out.println("在咖啡机中煮研磨好的咖啡豆～");
    }

    @Override
    public void complete() {
        System.out.println("一杯香醇的咖啡煮好了～");
    }
}
