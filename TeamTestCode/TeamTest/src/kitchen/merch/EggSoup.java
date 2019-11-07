package kitchen.merch;

import kitchen.staff.Visitor;
/**
 * 鸡蛋汤的实例化
 */
public class EggSoup extends Dish implements DishBuilder{
    private Dish ndish;

    public EggSoup(){
        this.ndish = new Dish();
    }
    /**
     * 以下依次是名称、餐具、价格、原料、厨具、原料数量
     */
    @Override
    public void setName(){
        ndish.setName("鸡蛋汤");
    }
    @Override
    public void setPack(){
        ndish.setPack("汤碗");
    }
    @Override
    public void setPrice(){
        ndish.setPrice(28.8);
    }
    @Override
    public void setMaterial(){
        ndish.setMaterial("鸡蛋");
    }
    @Override
    public void setCooker(){
        ndish.setCooker("电饭煲");
    }
    @Override
    public void setCount(){
        ndish.setCount(4);
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
