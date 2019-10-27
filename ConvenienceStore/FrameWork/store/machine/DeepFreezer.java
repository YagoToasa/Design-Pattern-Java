package store.machine;
/**
 * @className: DeepFreezer
 * @author: Kunyu Chen
 * @description: 冰柜每天检查、开关、清洁机器
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */
public class DeepFreezer {
    public void checkUp(){
        System.out.println("检查制冷机!");
        System.out.println("检查制冷剂!");
    }
    public void startUp(){
        System.out.println("开启制冷机!");
    }

    public void shutDown(){
        System.out.println("关闭制冷机!");
    }

    public void cleanUp(){
        System.out.println("清洗制冷机!");
    }
}
