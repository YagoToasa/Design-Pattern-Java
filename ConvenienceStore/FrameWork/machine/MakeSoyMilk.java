package machine;

/**
 * @className: MakeSoyMilk
 * @description: 制作豆浆
 * @author: Lanxin Liu
 * @designPattern: Template Method
 * @date: 23:59 2019/10/26
 * @version: v1.0
 */
public class MakeSoyMilk extends MakeDrink{
    @Override
    public void chooseBean() {
        System.out.println("精心挑选出农民伯伯种植的优质黄豆～");
    }

    @Override
    public void brewBeans() {
        System.out.println("在豆浆机中煮刚刚磨好的豆子～");
    }

    @Override
    public void complete() {
        System.out.println("一杯香醇的豆浆煮好了～");
    }
}
