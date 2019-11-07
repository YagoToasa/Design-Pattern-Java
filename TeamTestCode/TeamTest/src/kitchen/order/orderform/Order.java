package kitchen.order.orderform;
import kitchen.order.merchname.MerchNameFactory;
import kitchen.staff.Visitor;
import kitchen.staff.Waiter;
//import kitchen.staff.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 类Order是用来表示记录顾客消费信息的类 <br>
 * 该类实现了java内置的Cloneable接口，
 * 实现这个接口标识着Order类支持clone（）函数，
 * Prototype原型设计模式的核心是实现和使用此函数。<br>
 * 设计模式： Prototype
 * @author 贺思奇
 * @see MerchNameFactory
 */
public class Order implements Cloneable{

    /**
     * 记录订单号增长的静态变量，用于给每个订单分配订单号。
     */
    public static int count = 0;

    /**
     * 表示订单的编号。
     */
    private int oid;

    /**
     * 表示为此订单服务的服务员
     */
    private Waiter waiter;

    /**
     * 表示为匹配顾客数量而分配的餐桌大小。
     */
    private int tablesize;

    /**
     * 表示订单的折扣。
     */
    private double discount;
    /**
     * 表示顾客订的菜品列表。
     */
    private ArrayList<String> dishlist = new ArrayList<String>();
    /**
     * 表示顾客应付的金额（不计折扣）。
     */
    private double bill = 0;

    public Order(){
        oid = ++count;
    }

    /**
     * 设置本订单的服务员
     * @param w
     */
    public void setWaiter(Waiter w){
        this.waiter = w;
    }

    /**
     * 令服务员接收此订单
     */
    public void giveorder(){
        waiter.serve(this);
    }

    /**
     * 返回顾客的菜品清单
     * @return
     */
    public ArrayList<String> givemenu(){
        return dishlist;
    }


    /**
     * 显示当前订单中的菜单信息
     */
    public void showmenu(){
        for(String i: dishlist){
            System.out.println(i);
        }
    }



    /**
     * 根据顾客的数量，决定餐桌的大小。
     * @param persons 顾客数量
     */
    public void setTablesize(int persons) {
        if(persons < 4){
            this.tablesize = 1;
            System.out.println("为您分配4人桌。");
        }
        else if(persons < 6){
            this.tablesize = 2;
            System.out.println("为您分配6人桌。");
        }
        else{
            this.tablesize = 3;
            System.out.println("为您分配大~~桌");
        }
    }

    /**
     * 设定订单的折扣
     * @param discount
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * 获取订单折扣
     * @return 订单折扣
     */
    public double getDiscount(){
        return discount;
    }

    /**
     * 累计增加订单的应付金额（不计折扣）
     * @param money
     */
    public void addBill(double money){
        this.bill += money;
    }

    /**
     * 计算订单最终实付金额。
     */
    public void pay(){
        System.out.println("--桥接模式--");
        System.out.println("顾客共消费：" + (this.bill * this.discount) + "元。");
    }


    /**
     * clone()函数实现了Cloneable接口，
     * 允许用一个实例的clone（）来创建一个新的实例。<br>
     * 新的实例所有属性都和被克隆者相同，
     * 但他们二者却占据完全不同的内存空间。
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        Order o = (Order)super.clone();
        ArrayList<String> dl = new ArrayList<String>();
        o.tablesize = this.tablesize;
        o.discount = this.discount;
        o.bill = this.bill;
        for(String s:this.dishlist){
            dl.add(s);
        }
        o.dishlist = dl;
        return o;
    }

    /**
     * 接收顾客点的菜（套餐），
     * 将其转换成单个菜品记录在dishlist中。
     * @param name
     */
    public void adddish(String name) throws CloneNotSupportedException {
        List<String> merchs = MerchNameFactory.getMerchName(name);
        if(merchs != null) {
            Memento.getInstance().setBackup(this);
            for (String i : merchs) {
                this.dishlist.add(i);
            }
            System.out.println("菜品" + name + "已添加。");
        }
        else{
            System.out.println("此菜品没有~");
        }
    }

    /**
     * 接收顾客取消的菜品，
     * 将其从dishlist中删去。
     * @param name
     */
    public void canceldish(String name) throws CloneNotSupportedException {
        List<String> merchs = MerchNameFactory.getMerchName(name);
        if(merchs != null) {
            Memento.getInstance().setBackup(this);
            for (String i : merchs) {
                if(dishlist.contains(i)) {
                    dishlist.remove(i);
                    System.out.println("菜品" + i + "已删除。");
                }
                else{
                    System.out.println("菜品" + i + "不存在于订单中。");
                }
            }
        }
        else
            System.out.println("此菜品不存在。");
    }

    /**
     * 返回订单编号。
     * @return 订单编号
     */
    public int getOid(){
        return this.oid;
    }

    public void adjustclone(){
        this.oid++;
        count++;
    }

    /**
     * visitor的接受函数
     * @param visitor 访问者
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
