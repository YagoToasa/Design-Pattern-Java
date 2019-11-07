package kitchen.container;

import java.util.ArrayList;

import kitchen.ingredient.*;

/**
 * 抽象容器类。
 * 此类可放入不限数量的原料。
 * 可通过seek函数查找容器中原料的数量。
 * 可通过get函数获取容器中一定数量的原料。
 * 设计模式：迭代器模式。
 * @author 谢康
 */
public abstract class Container {

    /**
     * 原料列表，容器中的原料都存储在此
     */
    protected ArrayList<Ingredient> ingredients = new ArrayList<>();

    /**
     *储存此容器能够存放的原料
     */
    protected ArrayList<IngredientType> availableTypes;


    /**
     * Default constructor
     */
    public Container() {

    }

    /**
     * 放入食材，根据参数生成实例
     *
     * @param type 食材种类
     * @param count 此食材数量
     */
    public void put(IngredientType type, int count) {
        if(!isIngredientTypeAvailable(type))
            System.out.println(this.getName()+"里不允许放原料："+type.toString()+"!");
        else {
            // 这里可以改写abstract factory
            Ingredient temp;
            while (count > 0) {
                switch (type) {
                    case EGG:
                        temp = new Egg();
                        break;
                    case FISH:
                        temp = new Fish();
                        break;
                    case FLOUR:
                        temp = new Flour();
                        break;
                    case TOFU:
                        temp = new Tofu();
                        break;
                    default:
                        temp = new Vegetables();
                }
                ingredients.add(temp);
                count--;
            }
        }
    }

    /**
     * 消耗食材
     *
     * @param type 食材种类
     * @param count 此种食材合格数
     * @return 此容器含有超过此数量的此食材，返回ture，其他返回false。
     */
    public boolean get(IngredientType type, int count)
    {
        int ans = 0;
        ArrayList<Ingredient> temp = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getIngredientType() == type && ingredient.isState()) {
                temp.add(ingredient);
                ans++;
            }
        }
        if(ans>=count)
        {
            count--;
            while(count>=0)
            {
                (temp.get(count)).setCooked();;
                count--;
            }
            return true;
        }
        else {
            System.out.println(this.getName()+"里的"+type.toString()+"不够了！");
            return false;
        }
    }

    /**
     * 查找食材
     *
     * @param type 食材种类
     * @return 存在此种食材返回ture，否则反回false。
     */
    public int seek(IngredientType type) {
        int ans = 0;
        ContainerIterator iterator = Iterator();

        while(iterator.hasNext())
        {
            Ingredient temp = iterator.next();
            if (temp.getIngredientType() == type && temp.isState()) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 判断此原料能否放入此容器
     * 
     * @param type 
     * @return 
     */
    public boolean isIngredientTypeAvailable(IngredientType type) {
        return availableTypes.contains(type);
    }

    /**
     * 判断这些原料能否全部都能放入此容器
     * 
     * @param typeList
     * @return
     */
    public boolean isIngredientTypesAvailable(ArrayList<IngredientType> typeList) {
        for (IngredientType itype:typeList) {
            if(!availableTypes.contains(itype))return false;
        }
        return true;
    }

    /**
     * @return 此容器的迭代器
     */
    public ContainerIterator Iterator() { return new ContainerIterator(this.ingredients); }

    /**
     * @return 名称
     */
    public abstract String getName();

}
