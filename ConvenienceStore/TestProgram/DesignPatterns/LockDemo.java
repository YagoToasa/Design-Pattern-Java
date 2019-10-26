package DesignPatterns;

import FrameWork.world.WordLockThread;
import FrameWork.world.WorldClock;
/**
 * @className: LockDemo
 * @description: Double Click Lock 线程锁 测试程序
 * @author: 罗臻
 * @date: 11:39 上午 2019/10/26
 * @version: v1.0
 */
public class LockDemo {
    public static void main(String[] args){
        System.out.println("START ========================= Lock Demo =========================");
        System.out.println("开启三个线程占用世界时钟资源，线程1与线程3对世界时钟进行修改，线程2进行查看");
        for(int i=1; i<=WordLockThread.taskNums.length; ++i) {
            Thread wlt = new Thread(new WordLockThread(i));
            wlt.start();
        }
    }
}
