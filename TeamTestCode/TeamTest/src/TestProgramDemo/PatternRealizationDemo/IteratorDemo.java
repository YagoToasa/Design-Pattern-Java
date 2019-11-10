package TestProgramDemo.PatternRealizationDemo;

import kitchen.container.Cabinet;
import kitchen.container.ContainerIterator;
import kitchen.ingredient.Ingredient;
import kitchen.ingredient.IngredientType;
import kitchen.time.Time;
/**
 * @className: IteratorDemo
 * @description:
 * @author: Liwen Zhu
 * @date: 13:02  2019/11/10
 * @version: v1.0
 */
public class IteratorDemo {
    public static void main(String[] args)
    {
        System.out.println("START ========================= Iterator Demo =========================\n");
        Cabinet.getInstance().put(IngredientType.EGG,1);
        Cabinet.getInstance().put(IngredientType.FLOUR,1);
        Time.getInstance().update(99);
        ContainerIterator it = Cabinet.getInstance().Iterator();
        while(it.hasNext())
        {
            Ingredient ingredient = it.next();
            System.out.println("冰箱中有：【"+ingredient.getName()+"】" + ingredient.getStateName());
        }
        Time.getInstance().update(1);
        it = Cabinet.getInstance().Iterator();
        while(((ContainerIterator) it).hasNext())
        {
            Ingredient ingredient = it.next();
            System.out.println("冰箱中有：【"+ingredient.getName()+"】"+ ingredient.getStateName());
        }
        System.out.println("END ========================= Iterator Demo =========================\n");
    }

}