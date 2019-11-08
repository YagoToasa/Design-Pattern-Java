package TestProgramDemo.PatternRealizationDemo;

import kitchen.cooker.Cooker;
import kitchen.cooker.RiceCooker;
import kitchen.cooker.Steamer;
import kitchen.cooker.Wok;
import java.util.ArrayList;
import kitchen.ingredient.IngredientType;
import kitchen.ingredient.*;

/**
 * @className: TemplateMethodDemo
 * @author: Kunyu Chen
 * @description:
 * @date:  2019/11/9
 * @version: v1.0
 */
public class TemplateMethodDemo {
    public static void main(String[] args) {
        //用电饭煲烹饪鸡蛋
        RiceCooker mRiceCooker=new RiceCooker();
        Ingredient mEgg = new Egg();
        mRiceCooker.cook(mEgg);
        System.out.println("———");
        //用蒸笼烹饪面粉
        Steamer mSteamer=new Steamer();
        Ingredient mFlour = new Flour();
        mSteamer.cook(mFlour);
        System.out.println("———");
        //用锅烹饪鱼（不能烹饪）
        Wok mWok=new Wok();
        Ingredient mFish = new Fish();
        mWok.cook(mFish);
    }
}
