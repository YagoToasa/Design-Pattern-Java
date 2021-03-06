package store.machine;


/**
 * @className: MicrowaveOven
 * @author: Kunyu Chen
 * @description: 微波炉每天检查、开关、清洁机器
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */

public class MicrowaveOven {
    public void checkUp(){
        System.out.println("检查微波炉!");
        System.out.println("检查微波炉托盘!");
    }
    public void startUp(){
        System.out.println("开启微波炉!");
    }

    public void shutDown(){
        System.out.println("关闭微波炉!");
    }

    public void cleanUp(){
        System.out.println("清洗微波炉!");
    }
}
