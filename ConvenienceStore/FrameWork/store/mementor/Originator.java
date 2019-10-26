package store.mementor;
import foods.FoodRepository;

import java.util.HashMap;
import java.util.Map;
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
    private Map<String, Integer> state;

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
        return new Memento((HashMap) state);
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



    public void testState1(FoodRepository foodRepository){
        state = foodRepository.getFoodItemNumMap();
    };




    /**
     * @className: Memento
     * @author: Xian Zhou
     * @description: 备忘录格式
     * @designPattern: memento
     * @date: 2019/10/25
     * @version: v1.0 版本
     */
    private class Memento implements store.mementor.DataMemento {

        private Map<String, Integer> state;

        private Memento(HashMap state) {
            this.state = new HashMap(state);
        }

        private Map getState() {
            return state;
        }

        private void setState(HashMap state) {
            this.state = state;
        }
    }
}

