package kitchen.staff.chef;
import kitchen.merch.*;

import java.util.ArrayList;

/**
 * 命令模式
 */
public interface ChefImp{
    /**
     * 处理菜品列表,完成做菜，
     * 此处涉及Command模式
     * @param dishs 菜的列表
     */
    void processMerchs(ArrayList<Dish> dishs);
}