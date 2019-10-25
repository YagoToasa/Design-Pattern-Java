package adapter;

/**
 * @className: EatAndPowered
 * @description: 实现一边吃东西一边充电
 * @designPattern: Adapter
 * @author: Lanxin Liu
 * @date: 23:05 2019/10/25
 * @version: v1.0
 */
public class EatAndPowered implements FoodToEat{
    private Adapter adapter = new Adapter();

    @Override
    public void eat(String type, String how) {
        if("只吃东西".equals(how)) {
            if("snack".equals(type)) {
                System.out.println("顾客正在吃零食...");
            }
            if("pastry".equals(type)) {
                System.out.println("顾客正在吃糕点...");
            }
            if("drink".equals(type)) {
                System.out.println("顾客正在喝东西...");
            }
        }
        if("一边充电一边吃东西".equals(how)) {
            adapter.eat(type,how);
        }
    }
}
