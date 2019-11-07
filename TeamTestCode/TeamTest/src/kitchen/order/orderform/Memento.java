package kitchen.order.orderform;
import java.util.Hashtable;
import java.util.Stack;

/**
 * 类Memento是用来记录历史订单信息的类。<br>
 * 该类用调用Order类的clone()的方法，
 * 保证在每一次对Order的菜单进行操作时，记录当前订单信息。<br>
 * 如果顾客误操作，可以使用Memento提供的方法来回退订单到上一状态。<br>
 * 这用到了Memento的设计模式。<br>
 * Memento类本身只需要一个实例，这个实例被静态的保存在他本身的定义中。<br>
 * 这用到了Singleton设计模式。<br>
 * 在生成副本的过程中，每个订单根据订单号生成历史信息栈。<br>
 * 每个订单号对应一个栈，仅有在订单号存在时，才会生成栈；相同订单号的订单共享一个栈。<br>
 * 这用到了Flyweight设计模式。<br>
 * 设计模式： Memento，Singleton，Flyweight
 * @author 贺思奇
 * @see Order
 */
public class Memento {
    /**
     * 记录所有订单历史信息栈的“历史信息表”，
     * key值为订单号，value值为栈索引。
     */
    private Hashtable<Integer, Stack<Order>> pool = new Hashtable<Integer, Stack<Order>>();
    /**
     * 静态方法保存唯一的单例。
     */
    private static Memento memt = new Memento();

    // 将Memento的构造函数设置为private，保证他不会在其他类中被创建。
    private Memento(){};

    /**
     * 返回单例。
     * @return 唯一的Memento实例。
     */
    public static Memento getInstance() { return memt; }

    /**
     * 对传入的订单，获得其备份。
     * @param o 传入的订单实例
     * @return 备份的订单实例（上一步订单）
     */
    public Order getBackup( Order o ) {
        Stack<Order> backup = (Stack<Order>)pool.get(o.getOid());
        if(backup == null || backup.empty()) {
            System.out.println("此订单不存在备份。");
            return o;
        }
        return backup.pop();
    }

    /**
     * 对传入的订单，设置一个备份
     * @param o 传入的订单实例
     * @throws CloneNotSupportedException
     */
    public void setBackup( Order o ) throws CloneNotSupportedException {
        Order backup = (Order)o.clone();
        if( pool.containsKey(o.getOid()) ) {
            pool.get(o.getOid()).push(backup);
        }
        else{
            Stack<Order> s = new Stack<Order>();
            s.push(o);
            pool.put(o.getOid(), s);
            pool.get(o.getOid()).push(backup);
        }
    }

}
