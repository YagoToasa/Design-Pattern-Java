package store.machine;

/**
 * @className: IceCreamMachine
 * @author: Kunyu Chen
 * @description: 冰淇淋机每天检查、开关、清洁机器
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */

public class IceCreamMachine {
    public void checkUp(){
        System.out.println("IceCreamMachine checkup!");
        System.out.println("检查制冷剂");
        System.out.println("检查奶油");
    }
    public void startUp(){
        System.out.println("IceCreamMachine startup!");
    }

    public void shutDown(){
        System.out.println("IceCreamMachine shutdown!");
    }

    public void cleanUp(){
        System.out.println("IceCreamMachine cleanup!");
    }
}
