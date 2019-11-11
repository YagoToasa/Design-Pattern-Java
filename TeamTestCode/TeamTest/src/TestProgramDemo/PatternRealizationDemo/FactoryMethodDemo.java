package TestProgramDemo.PatternRealizationDemo;

import kitchen.order.merchname.MerchNameFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @className: FactoryMethodDemo
 * @description:
 * @author: Yinan Cheng
 * @date: 13:55  2019/11/11
 * @version: v1.0
 */
public class FactoryMethodDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("START ========================= Factory Method Demo =========================\n");
        List<String> names= null;

        //点不同的商品
        List<String> orders= Arrays.asList("水煮鱼","炒青菜","麻婆豆腐套餐");
        //点餐

        for(String s:orders){
            System.out.print("现在点");
            System.out.println(s);

            names= MerchNameFactory.getMerchName(s);

            //如果点的菜不存在，就会获取到空指针，如果存在，会获取到单品名称的List
            if(names==null){
                System.out.println("没有");
                System.out.println(s);
            }else{
                System.out.println("点的菜包括：");
                for(String ss:names){
                    System.out.println(ss);
                }
            }
        }
        System.out.println("E N D ========================= Factory Method Demo =========================\n");
    }
}
