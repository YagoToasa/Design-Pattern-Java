package kitchen.ingredient;

/**
 * 原料种类枚举。
 * 已有的枚举类型实例可以通过toString返回名称。
 * @author 谢康
 */
public enum IngredientType 
{
    FISH("鱼"), EGG("鸡蛋"),FLOUR("面粉"),TOFU("豆腐"),VEGETABLES("蔬菜");

    String name;

    IngredientType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}