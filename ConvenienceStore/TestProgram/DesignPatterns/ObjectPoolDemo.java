package DesignPatterns;

import charger.*;

/**
 * @className: ChargerPoolDemo
 * @description: 对象池模式测试程序
 * @author: Liwen Zhu
 * @date: 13:06 2019/10/27
 * @version: v1.0
 */
public class ObjectPoolDemo {
    public static void main(String[] args) {
        System.out.println("START =========================== Adaptor Demo ==========================");
        ChargerPool objPool = new ChargerPool();
        objPool.createPool();
        System.out.println("-------------------");
        System.out.println("-- 顾客1号扫码借充电宝... --");
        Object obj = objPool.getCharger();
        System.out.println("-------------------");

        System.out.println("-- 顾客1号归还充电宝 --");
        objPool.returnObject(obj);
        System.out.println("-------------------");
        System.out.println("-- 顾客2号扫码借充电宝... --");
        Object obj2 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客3号扫码借充电宝... --");
        Object obj3 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客4号扫码借充电宝... --");
        Object obj4 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客5号扫码借充电宝... --");
        Object obj5 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客6号扫码借充电宝... --");
        Object obj6 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客7号扫码借充电宝... --");
        Object obj7 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("-- 顾客6号归还充电宝 --");
        objPool.returnObject(obj6);
        System.out.println("-------------------");
        System.out.println("-- 顾客8号扫码借充电宝... --");
        Object obj8 = objPool.getCharger();
        System.out.println("-------------------");
        System.out.println("E N D =========================== Adaptor Demo ==========================\n");

    }
}