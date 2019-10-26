package adapter;

/**
 * @className: ElectricPower
 * @description: 电源
 * @designPattern: Adapter
 * @author: Lanxin Liu
 * @date: 20:10 2019/10/24
 * @version: v1.0
 */
public class ElectricPower implements Power {
    /**
     * 为客人提供充电线
     * 
     * @methodName: providePower
     * @param: type
     * @return: 
     */
    @Override
    public void providePower(String type) {
        if("安卓".equals(type)) {
            android();
        }
        if("苹果".equals(type)) {
            apple();
        }
    }
    private void android() {
        System.out.println("顾客的安卓手机正在充电！");
    }
    private void apple() {
        System.out.println("顾客的苹果手机正在充电！");
    }
}
