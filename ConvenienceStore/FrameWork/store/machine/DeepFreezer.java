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
        System.out.println("DeepFreezer checkup!");
        System.out.println("检查制冷剂");
    }
    public void startUp(){
        System.out.println("DeepFreezer startup!");
    }

    public void shutDown(){
        System.out.println("DeepFreezer shutdown!");
    }

    public void cleanUp(){
        System.out.println("DeepFreezer cleanup!");
    }
}
