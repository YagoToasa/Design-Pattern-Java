package kitchen.ingredient;

/**
 * 处理方法接口。
 * displayCut用以显示处理方法。
 * isCut用以显示是否已处理。
 * 设计模式：装饰器模式。
 * @author 谢康
 */
public interface CutInterface {
     abstract void displayCut();
     abstract boolean isCut();
}
