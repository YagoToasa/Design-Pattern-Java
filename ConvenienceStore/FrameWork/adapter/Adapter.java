package adapter;

import person.Customer;
/**
 * @className: Adapter
 * @description: 适配器类
 * @author: Lanxin Liu
 * @date: 20:14 2019/10/24
 * @version: v1.0
 */
public class Adapter implements FoodToEat{
    private Power power;
    @Override
    public void eat(String type, String how) {
        if("一边充电一边吃东西".equals(how)) {
            System.out.println("顾客正在一边吃东西一边充电！");
            beingPowered(type);
            power.providePower(type);
        }
    }
    private void beingPowered(String type) {
        if(type.equals("安卓")||type.equals("苹果")) {
            power = new ElectricPower();
        }
        else{
            System.out.println("本店不提供该类型的服务！");
        }
    }
}
