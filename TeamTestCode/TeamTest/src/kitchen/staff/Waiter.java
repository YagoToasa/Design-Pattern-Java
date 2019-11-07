package kitchen.staff;

import kitchen.merch.*;
import kitchen.order.orderform.Order;
import kitchen.staff.chef.Chef;


import java.util.ArrayList;

/**
* 类Waiter是多个设计模式的集合类
* Proxy代理设计模式：Waiter类为Proxy的代理类
*                   调用真实主题的处理方法时为真实主题进行预处理和后处理
*
* Mediator中介者设计模式：Waiter类时厨师（Chef）类与订单（Order）类的中介者
*                        负责处理二者之间的信息传递
*
* Visitor访问者设计模式：Waiter类实现Visitor，作为一个具体访问者，既可以访问
*                       单一菜品，也可以访问整个订单，操作不同。
* 设计模式：Proxy，Mediator，Visitor
* @author 卢朋艺，李航
*/
public class Waiter implements Visitor,WaiterInterface{
    /**
    * 表示该服务员将要服务的厨师
    */
    private Chef mChef;

    /**
     * 表示该服务员将要服务的订单
     */
    private Order mOrder;
    
    /**
    * 表示从订单中拿到的String类型的菜名列表
    */
    private ArrayList<String> lists;

    /**
    * 表示将String类型的菜名转换为Dishes后的列表
    */
    private ArrayList<Dish> dishes;


    /**
    * 表示真正去处理订单与厨师之间交互的真实服务员
    */
    private RealWaiter realWaiter = RealWaiter.getInstance();

    /**
    * 生成一个服务员实例
    */
    private static Waiter instance = new Waiter();

    /**
    *私有化构造函数以实现单例模式
    */
    private Waiter(){
        if (instance == null) {
            instance = this;
            realWaiter.setmWaiter(this);
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    /**
    * 返回服务员单例
    */
    public static Waiter getInstance(){
        return instance;
    }

    /**
    * 获取服务员将要服务的订单和厨师
    */
    public void register(Chef chef){
        mChef = chef;
        realWaiter.setmChef(chef);
        chef.setWaiter(this);
        System.out.println("厨师已登记到服务员处");
    }
    public void register(Order order){
        mOrder = order;
        realWaiter.setmOrder(order);
        order.setWaiter(this);
        System.out.println("订单已获得服务员受理");
    }

    /**
    * 表示在厨师做好菜后为厨师服务的方法
    * 真实服务员进行实际处理
    */
    @Override
    public void serve(Chef chef){
        System.out.println("--中介者、代理模式--");
        System.out.println("服务员开始为厨师服务");
        realWaiter.serve(chef);
        System.out.println("服务员为厨师服务结束");
        System.out.println("--中介者、代理模式--");
    }

    /**
    * 表示在订单填写完成后为订单服务的方法
    * 真实服务员进行实际处理
    * 并从真实服务员处取到菜名的两种列表
    */
    @Override
    public void serve(Order order){
        System.out.println("--中介者、订单模式--\n");
        realWaiter.serve(order);


        lists = realWaiter.getLists();
        dishes = realWaiter.getDishes();
    }


    /**
    * 表示为Lists的设置与获取
    */
    public void setLists(ArrayList<String> lists) {
        this.lists = lists;
    }

    public ArrayList<String> getLists() {
        return lists;
    }


    /**
    * 访问者模式
    * 表示对菜品菜名和价格的访问
    */
    @Override
    public void visit(Dish dish) {
        System.out.println(dish.getName() + ":" + dish.getPrice() + "元");
    }

    /**
    * 访问者模式
    * 表示对订单中所有菜品的访问并打印最后的总价
    */
    @Override
    public void visit(Order order) {
        System.out.println("访问订单：");
        for (Dish dish: dishes) {
            this.visit(dish);
            mOrder.addBill(dish.getPrice());
        }
        mOrder.pay();
    }

    /**
     * 获取菜的列表，用于各种测试
     * @return 菜的列表
     */
    public ArrayList<Dish> getDishes(){
        return dishes;
    }
}