package store.summary;

import store.machine.Coffeemaker;
import store.machine.DeepFreezer;
import store.machine.IceCreamMachine;
import store.machine.MicrowaveOven;

/**
 * @className: StoreDailySummary
 * @author: Kunyu Chen
 * @description: 便利店每天检查、开关、清洁机器
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */

public class StoreDailySummary {


    private Coffeemaker coffeeMaker;
    private IceCreamMachine iceCreamMachine;
    private DeepFreezer deepFreezer;
    private MicrowaveOven microwaveOven;
    /**
     * 初始化DailySummary里面的成员
     *
     * @methodName: storeDailySummary
     * @param:
     * @return: void
     */
    public void storeDailySummary(){
        coffeeMaker=new Coffeemaker();
        iceCreamMachine=new IceCreamMachine();
        deepFreezer=new DeepFreezer();
        microwaveOven=new MicrowaveOven();
    }

    /**
     * 全部开启，用于来电的时候，要将所有机器重启
     *
     * @methodName: startUpAll
     * @param:
     * @return: void
     */
    public void startUpAll(){
        System.out.println("开始开启器械!");
        coffeeMaker.startUp();
        iceCreamMachine.startUp();
        deepFreezer.startUp();
        microwaveOven.startUp();
        System.out.println("器械开启完成[Completed]!");
        System.out.println("————");
    }

    /**
     * 全部关闭，用于模拟停电
     *
     * @methodName: shutDownAll
     * @param:
     * @return: void
     */
    public void shutDownAll(){
        System.out.println("开始关闭器械!");
        coffeeMaker.shutDown();
        iceCreamMachine.shutDown();
        deepFreezer.shutDown();
        microwaveOven.shutDown();
        System.out.println("器械关闭完成[Completed]!");
        System.out.println("————");
    }
    /**
     * 检查全部机器
     *
     * @methodName: checkUpAll
     * @param:
     * @return: void
     */
    public void checkUpAll(){
        System.out.println("开始检查器械!");
        coffeeMaker.checkUp();
        iceCreamMachine.checkUp();
        deepFreezer.checkUp();
        microwaveOven.checkUp();
        System.out.println("器械检查完成[Completed]!");
        System.out.println("————");
    }

    /**
     * 检查全部机器
     *
     * @methodName: cleanUpAll
     * @param:
     * @return: void
     */
    public void cleanUpAll(){
        System.out.println("开始清洗器械!");
        coffeeMaker.cleanUp();
        iceCreamMachine.cleanUp();
        deepFreezer.cleanUp();
        microwaveOven.cleanUp();
        System.out.println("器械清洗完成[Completed]!");
        System.out.println("————");
    }
}