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
        System.out.println("检查冰淇淋机!");
        System.out.println("检查制冷剂!");
        System.out.println("检查奶油!");
    }
    public void startUp(){
        System.out.println("开启冰淇淋机!");
    }

    public void shutDown(){
        System.out.println("关闭冰淇淋机!");
    }

    public void cleanUp(){
        System.out.println("清洗冰淇淋机!");
    }
}
