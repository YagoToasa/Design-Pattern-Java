package TeamTestCode.TeamTest.src.TestProgramDemo.PatternRealizationDemo;
import kitchen.ingredient.Egg;
import kitchen.ingredient.Ingredient;
/**
 * @className: StrategyDemo
 * @description:
 * @author: Wenyue Li
 * @date: 9:17 下午 2019/11/9
 * @version: v1.0
 */
public class StrategyDemo {
    public static void main(String[] args) {
        /**
         * 策略模式测试
         */
        System.out.println("START ========================= Strategy Demo =========================\n");
        Ingredient ing = new Egg();
        System.out.println("我们尝试创造一个实例鸡蛋");
        System.out.println("鸡蛋的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("过去15个时间，实例的状态是否新鲜：");
        int i = 15;
        while (i-- > 0)
            ing.update();
        System.out.println(ing.isState());
        i = 100;
        while (i-- > 0)
            ing.update();
        System.out.println("再过去100个时间,实例的状态是否新鲜：");
        System.out.println(ing.isState());
        System.out.println("食物状态改变，这里用到了策略模式");
        System.out.println("E N D ========================= Strategy Demo =========================\n");

    }
}
