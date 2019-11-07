package kitchen.staff;

import kitchen.merch.*;
import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;

import java.util.ArrayList;


/**
* 类RealWaiter是用来实际处理厨师与订单之间信息传递的类
* Proxy代理设计模式使用此类为真实主题
* 设计模式： Proxy
* @author 卢朋艺
* */
public class RealWaiter implements WaiterInterface {
    /**
    * 表示真实服务员服务的厨师
    */
    private Chef mChef;

    /**
    * 表示真实服务员服务的订单
    */
    private Order mOrder;

    /**
    * 表示真实服务员的代理服务员
    */
    private  Waiter mWaiter = Waiter.getInstance();

    /**
    * 表示从订单中拿到的String类型的菜名列表
    */
    private ArrayList<String> lists;

    /**
     * 表示将String类型的菜名转换为Dishes后的列表
     */
    private ArrayList<Dish> dishes;

    /**
     * 生成一个服务员实例
     */
    private static RealWaiter instance = new RealWaiter();

    /**
     *私有化构造函数以实现单例模式
     */
    private RealWaiter(){
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
     * 返回服务员单例
     */
    public static RealWaiter getInstance(){
        return instance;
    }


    /**
    * 表示为厨师服务的方法
    */
    @Override
    public void serve(Chef chef){
        System.out.println("服务员已经拿到菜了");
    }

    /**
    * 表示为订单服务的方法
    * 从订单中获得String类型的菜名列表
    * 使用Adaptor将列表转换为Dishes类型的列表
    * 将Dishes类型的列表转交给厨师
    */
    @Override
    public void serve(Order order){
        lists = mOrder.givemenu();

        if(lists != null) {
            mWaiter.setLists(lists);

            Adapter adapter = new Adapter();
            dishes = adapter.getDishes();

            System.out.println("订单开始传递给厨师");
            informChef();
        }
        else
            System.out.println("菜单有误");
    }

    /**
    *为真实服务员服务的厨师设置其Dishes类型的菜名列表
    */
    public void informChef(){
        mChef.setDishes(dishes);
        System.out.println("厨师已经拿到菜单");
    }

    /**
    * 设置真实服务员服务的厨师
    */
    public void setmChef(Chef mChef) {
        this.mChef = mChef;
    }

    /**
    * 设置真实服务员服务的订单
    */
    public void setmOrder(Order mOrder) {
        this.mOrder = mOrder;
    }

    /**
    * 设置真实服务员的代理服务员
    */
    public void setmWaiter(Waiter mWaiter) {
        this.mWaiter = mWaiter;
    }

    /**
    * 返回真实服务员处理后的String的菜名列表
    */
    public ArrayList<String> getLists() {
        if(lists != null)
            return lists;
        else
            return null;
    }

    /**
     * 返回真实服务员处理后的Dishes的菜名列表
     */
    public ArrayList<Dish> getDishes() {
        if(dishes != null)
            return dishes;
        else
            return null;
    }
}
