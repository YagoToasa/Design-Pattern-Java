package decoration.furniture;

import decoration.visitor.FurnitureAcceptor;

/**
 * @className: Furniture
 * @author: Siqian Wu
 * @description: 家具类
 * @date: 10:09 2019-10-23
 * @version: v1.0 版本
 */
public abstract class Furniture implements FurnitureAcceptor {
    protected String name;      //家具名称：如桌子、椅子

    public Furniture(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    /**
     * 获取家具属性
     *
     * @methodName: getAttribute
     * @param: []
     * @Return: java.lang.String
     */
    abstract String getAttribute();

}
