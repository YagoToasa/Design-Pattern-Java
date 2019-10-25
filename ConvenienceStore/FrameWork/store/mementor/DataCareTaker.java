package store.mementor;

import java.util.HashMap;

/**
 * @className: DataCareTaker
 * @author: Xian Zhou
 * @description: 管理备忘录
 * @designPattern: memento
 * @date: 2019/10/25
 * @version: v1.0 版本
 */
public class DataCareTaker {

    private HashMap<String, DataMemento> mementomap;

    public DataCareTaker() {
        mementomap = new HashMap<String, DataMemento>();
    }


    /**
     * 返回之前的备忘录
     *
     * @methodName:  retrieveMemento
     * @param: String name
     * @return: DataMemento
     */
    public DataMemento retrieveMemento(String name) {
        return mementomap.get(name);
    }

    /**
     * 保存此备忘录
     *
     * @methodName:  saveMemento
     * @param: String name, DataMemento memento
     * @return: void
     */
    public void saveMemento(String name, DataMemento memento) {
        this.mementomap.put(name, memento);
    }
}

