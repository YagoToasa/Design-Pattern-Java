package kitchen.merch;

import kitchen.staff.Visitor;
/**
 * 馒头的实例化
 */
public class SteamedBread implements DishBuilder{
    private Dish ndish;

    public SteamedBread(){
        this.ndish = new Dish();
    }
    /**
     * 以下依次是名称、餐具、价格、原料、厨具、原料数量
     */
    @Override
    public void setName(){
        ndish.setName("蒸馒头");
    }
    @Override
    public void setPack(){
        ndish.setPack("盘子");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(1.5);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("面粉");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("蒸笼");
    }
    @Override
    public void setCount(){
        ndish.setCount(1);
    }
    /**
     * 生成以后通过这个函数来调用此实例
     */
    @Override
    public Dish getDish(){
        return ndish;
    }
    /**
     * visitor的接受函数
     */
    @Override
    public void accept(Visitor visitor){
        this.getDish().accept(visitor);
    }
}
