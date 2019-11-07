package kitchen.merch;

import kitchen.staff.Visitor;
/**
 * 菜品的主类
 */
public class Dish {
    /**
     * 商品的名字
     */
    private String name;
    /**
     * 商品的价格
     */
    private double price;
    /**
     * 商品使用的餐具
     */
    private String pack;
    /**
     * 商品的原料和需求的数量
     */
    private String material;
    private int count;
    /**
     * 商品使用的厨具
     */
    private String cooker;
    /**
     * 以下的方法分别是设置和获取菜品的名字、餐具、价格、原料、原料数目、厨具
     */
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getPack(){
        return pack;
    }
    public void setPack(String pack){
        this.pack = pack;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getMaterial(){
        return material;
    }
    public void setMaterial(String material){
        this.material = material;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public String getCooker(){
        return cooker;
    }
    public void setCooker(String cooker) {
        this.cooker = cooker;
    }
    /**
     * visitor的接受函数
     */
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
