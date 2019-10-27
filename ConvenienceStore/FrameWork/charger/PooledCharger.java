package charger;

/**
 * @className: PooledCharger
 * @description: 对象池类
 * @author: Liwen Zhu
 * @date: 13:06 2019/10/27
 * @version: v1.0
 */
public class PooledCharger {

    Object objection = null;// 对象
    boolean busy = false; // 此对象是否正在使用的标志，默认没有正在使用

    // 构造函数，根据一个 Object 构告一个 PooledObject 对象
    public PooledCharger(Object objection) {

        this.objection = objection;

    }

    // 返回此对象中的对象
    public Object getObject() {
        return objection;
    }

    // 设置此对象的，对象
    public void setObject(Object objection) {
        this.objection = objection;

    }

    // 获得对象对象是否忙
    public boolean isBusy() {
        return busy;
    }

    // 设置对象的对象正在忙
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
