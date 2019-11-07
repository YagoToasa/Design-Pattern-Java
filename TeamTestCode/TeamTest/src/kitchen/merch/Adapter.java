package kitchen.merch;
import java.util.ArrayList;

import kitchen.staff.Waiter;
import kitchen.staff.chef.Target;

/**
 * 实现厨师的请求
 */
public class Adapter implements Target {
    //被适配的对象
    private Waiter waiter = Waiter.getInstance();
    //被适配的字符串
    private ArrayList<String> list = waiter.getLists();
    /**
     * 适配函数，将字符串列表转换为菜的列表
     * @return 菜的列表
     */
    @Override
    public ArrayList<Dish> getDishes() {
        System.out.println("--适配者、外观模式--");
        ArrayList<Dish> dishes = new ArrayList<>();
        for (String string: list){
            Item item = new Item();
            int flag = 1;
            System.out.println("建造了 " + string);
            switch (string){
                case "水煮鱼":
                    item.setBuilder(new BoiledFish());
                    break;
                case "鸡蛋汤":
                    item.setBuilder(new EggSoup());
                    break;
                case "麻婆豆腐":
                    item.setBuilder(new MaboTofu());
                    break;
                case "馒头":
                    item.setBuilder(new SteamedBread());
                    break;
                case "炒青菜":
                    item.setBuilder(new StirFriedVegetables());
                    break;
                default:flag = 0;
            }
            if (flag == 1){
                item.createDish();
                Dish dish = item.getDish();
                dishes.add(dish);
            }
            else {
                System.out.println("菜单有误，请检测");
                return null;
            }
        }
        return dishes;
    }
}
