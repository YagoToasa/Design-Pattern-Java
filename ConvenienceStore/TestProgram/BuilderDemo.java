import sale.combo.*;

/**
 * @className: BuilderDemo
 * @description: Builder 建造者模式 测试程序
 * @author: Shidan Cheng
 * @date: 3:53 下午 2019/10/22
 * @version: v1.0
 */
public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("START ========================== Builder Demo ==========================");
        System.out.println("> 制作A套餐");
        ComboBuilder ACombo = new AComboBuilder();
        ComboDirector director = new ComboDirector(ACombo);
        System.out.println("> 制作A套餐 [Completed]");
        System.out.println("---");
        System.out.println("> 制作B套餐");
        ComboBuilder BCombo = new BComboBuilder();
        director = new ComboDirector(BCombo);
        System.out.println("> 制作B套餐 [Completed]");
        System.out.println("---");


        System.out.println("E N D ========================== Builder Demo ==========================\n");
    }
}
