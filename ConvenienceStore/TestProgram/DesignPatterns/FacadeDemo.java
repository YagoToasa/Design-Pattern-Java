package TestProgram.DesignPatterns;

import store.summary.StoreDailySummary;

/**
 * @className: FacadeDemo
 * @author: Kunyu Chen
 * @description: Facade模式测试类
 * @designPattern: Facade
 * @date: 2019-10-27
 * @version: v1.0
 */
public class FacadeDemo {

    public static void main(String[] args){
        System.out.println("START ========================= Facade Demo =========================");

        StoreDailySummary mStoreDailySummary= new StoreDailySummary();
        mStoreDailySummary.storeDailySummary();

        System.out.println("便利店的一日检查！");
        mStoreDailySummary.checkUpAll();

        System.out.println("便利店停电了！");
        mStoreDailySummary.shutDownAll();

        System.out.println("便利店来电了！");
        mStoreDailySummary.startUpAll();

        System.out.println("便利店的大扫除！");
        mStoreDailySummary.cleanUpAll();



       System.out.println("E N D ========================= Facade Demo =========================");
    }

}
