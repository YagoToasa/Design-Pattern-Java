package charger;

import java.util.Vector;
import java.util.Enumeration;

/**
 * @className: ChargerPool
 * @description: 对象池类
 * @author: Liwen Zhu
 * @date: 13:06 2019/10/27
 * @version: v1.0
 */
public class ChargerPool {
    private int maxObjects = 5;
    private Vector objects = null;

    public ChargerPool() {
    }

    /*** 创建一个对象池***/
    public synchronized void createPool(){
        // 确保对象池没有创建。如果创建了，保存对象的向量 objects 不会为空
        if (objects != null) {
            return; // 如果己经创建，则返回
        }

        // 创建保存对象的向量 , 初始时有 0 个元素
        objects = new Vector();

        // 根据 numObjects 中设置的值，循环创建指定数目的对象
        if (objects.size()== 0){
        for (int x = 0; x < maxObjects; x++) {
                Object obj = new Object();
                objects.addElement(new PooledCharger(obj));
        }
}
        System.out.println("-- 便利店共有5个充电宝 --");
    }

    public synchronized Object getCharger(){
        // 确保对象池己被创建
        if (objects == null) {
            return null; // 对象池还没创建，则返回 null
        }

        Object conn = getFreeCharger(); // 获得一个可用的对象

        // 如果目前没有可以使用的对象，即所有的对象都在使用中
        while (conn == null) {
              System.out.println("-- 提示：没有空闲充电宝！ --");
              break;
        }

        return conn;// 返回获得的可用的对象
    }


    private Object getFreeCharger(){

        // 从对象池中获得一个可用的对象
        Object obj = findFreeCharger();

        if (obj == null) {
            return null;     //如果目前对象池中没有可用的对象，创建一些对象

        }
        return obj;
    }


    private Object findFreeCharger() {

        Object obj = null;
        PooledCharger pObj = null;

        // 获得对象池向量中所有的对象
        Enumeration enumerate = objects.elements();

        // 遍历所有的对象，看是否有可用的对象
        while (enumerate.hasMoreElements()) {
            pObj = (PooledCharger) enumerate.nextElement();

            // 如果此对象不忙，则获得它的对象并把它设为忙
            if (!pObj.isBusy()) {
                obj = pObj.getObject();
                pObj.setBusy(true);
                System.out.println("-- 提示：借取成功！ --");
                break;
            }else {obj=null;}

        }
        return obj;// 返回找到到的可用对象
    }


        public void returnObject (Object obj){

            PooledCharger pObj = null;
            Enumeration enumerate = objects.elements();

            // 遍历对象池中的所有对象，找到这个要返回的对象对象
            while (enumerate.hasMoreElements()) {
                 pObj = (PooledCharger) enumerate.nextElement();

                // 先找到对象池中的要返回的对象对象
                if (obj == pObj.getObject()) {
                    // 找到了 , 设置此对象为空闲状态
                    pObj.setBusy(false);
                    break;
                }

            }
            System.out.println("-- 提示：归还成功！ --");
        }

    }





