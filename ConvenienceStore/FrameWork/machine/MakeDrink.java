package machine;

/**
 * @className: MakeDrink
 * @description: 制作饮品的过程
 * @author: Lanxin Liu
 * @designPattern: Template Method
 * @date: 23:59 2019/10/26
 * @version: v1.0
 */
public abstract class MakeDrink {
    /**
     * 提供饮品
     *
     * @methodName: provideDrink
     * @param:
     * @return:
     */
    public final void provideDrink() {
        System.out.println("-- 开始制作！--");
        chooseBean();
        grindBeans();
        brewBeans();
        complete();
    }
    /**
     * 抽象方法挑选豆子
     *
     * @methodName: chooseBean
     * @param:
     * @return:
     */
    public abstract void chooseBean();

    public void grindBeans() {
        System.out.println("将选好的豆子放进破壁机中研磨...");
    }

    public abstract void brewBeans();

    public abstract void complete();

}
