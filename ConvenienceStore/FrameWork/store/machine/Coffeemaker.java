package store.machine;
/**
 * @className: Coffeemaker
 * @author: Kunyu Chen
 * @description: 咖啡机的开启清洁检查
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */
public class Coffeemaker {

    public void checkUp(){
        System.out.println("检查咖啡机!");
        System.out.println("检查咖啡豆!");
        System.out.println("检查牛奶!");
    }
    public void startUp(){
        System.out.println("开启咖啡机!");
    }

    public void shutDown(){
        System.out.println("关闭咖啡机!");
    }

    public void cleanUp(){
        System.out.println("清洗咖啡机!");
    }
}
