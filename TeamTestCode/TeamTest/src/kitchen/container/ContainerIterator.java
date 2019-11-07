package kitchen.container;

import kitchen.ingredient.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 容器迭代器类
 * 设计模式：迭代器模式
 * @author Vector Xie
 */
public class ContainerIterator implements Iterator<Ingredient>{

    private ArrayList<Ingredient> ingredients;

    private int index;

    public ContainerIterator(ArrayList<Ingredient> ingredients) {
       this.ingredients = ingredients;
       index = 0;
    }

    public boolean hasNext() {
        return index < ingredients.size();
    }

    public Ingredient next() {
        return ingredients.get(index++);
    }

}
