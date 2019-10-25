package store.mementor;
import java.util.HashMap;
/**
 * @className: Origintor
 * @author: Xian Zhou
 * @description: 备忘录使用
 * @designPattern: memento
 * @date: 2019/10/25
 * @version: v1.0 版本
 */
public class Originator {
    // 暂用哈希表存储当前库存状态
    private HashMap<String, String> state;

    public Originator() {
        state = new HashMap();
    }


    /**
     * 创建备忘录
     *
     * @methodName:  createMemento
     * @param: 无
     * @return: DataMemento
     */
    public store.mementor.DataMemento createMemento() {
        return new Memento(state);
    }

    /**
     * 取回存档备忘录
     *
     * @methodName:  restoreMemento
     * @param: DataMemento memento
     * @return: void
     */
    public void restoreMemento(store.mementor.DataMemento memento) {
        state = ((Memento) memento).getState();
    }
    /**
     * 显示当前状态（未写入备忘录）
     *
     * @methodName:  showState
     * @param: 无
     * @return: void
     */
    public void showState() {
        System.out.println("当前存货状态:" + state.toString());

    }

    //当前的状态，等待调用仓库处返回值
    public void testState1() {
        state.put("bread", "50");
        state.put("sweet", "20");
        state.put("coffee", "5");

    }

    //仓库变动后的状态，等待调用仓库处返回值
    public void testState2() {
        state.put("bread", "40");
        state.put("sweet", "20");
        state.put("coffee", "5");


    }

    /**
     * @className: Memento
     * @author: Xian Zhou
     * @description: 备忘录格式
     * @designPattern: memento
     * @date: 2019/10/25
     * @version: v1.0 版本
     */
    private class Memento implements store.mementor.DataMemento {

        private HashMap<String, String> state;

        private Memento(HashMap state) {
            this.state = new HashMap(state);
        }

        private HashMap getState() {
            return state;
        }

        private void setState(HashMap state) {
            this.state = state;
        }
    }
}

