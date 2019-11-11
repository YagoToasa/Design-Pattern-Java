package TestProgramDemo.PatternRealizationDemo;

import kitchen.container.Fridge;

/**
 * @className: SingletonDemo
 * @description:
 * @author: Yinan Cheng
 * @date: 13:55  2019/11/11
 * @version: v1.0
 */
public class SingletonDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================= Singleton Demo =========================\n");
        Fridge fri = Fridge.getInstance();
        if(fri!=null)
            System.out.println("--单例冰箱获取成功！--");
        System.out.println("E N D ========================= Singleton Demo =========================\n");
    }
}
