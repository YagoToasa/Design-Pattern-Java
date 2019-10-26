package DesignPatterns;

import world.WorldClock;

import java.util.Optional;

/**
 * @className: DesignPatterns.SingletonDemo
 * @description: SingleDemo 单例模式 测试程序
 * @author: Shidan Cheng
 * @date: 9:04 下午 2019/10/22
 * @version: v1.0
 */
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("START ========================= Singleton Demo =========================");
        System.out.println("> 世界时钟单例测试");
        System.out.println(">>> 获取世界时钟实例 * 2");
        WorldClock clockInstanceOne = WorldClock.getInstance();
        WorldClock clockInstanceTwo = WorldClock.getInstance();
        System.out.printf(">>> 对比两个时钟的地址  ");
        if (clockInstanceOne == clockInstanceTwo){
            System.out.println("---> 地址值相同");
        }else{
            System.out.println("---> 地址值不同");
        }
        System.out.println(">>> 世界时钟-DAY: " + clockInstanceOne.getDay());
        System.out.printf(">>> 通过实例1-设置时钟[DAY]为[7]  ");
        clockInstanceOne.setDay(7);
        System.out.println("---> 设置完成");

        System.out.println(">>> 通过实例2查看时钟值");
        System.out.println(">>> 世界时钟-DAY: " + clockInstanceTwo.getDay());

        System.out.println("> 世界时钟单例测试 [Completed]");
        System.out.println("E N D ========================= Singleton Demo =========================\n");
    }
}
