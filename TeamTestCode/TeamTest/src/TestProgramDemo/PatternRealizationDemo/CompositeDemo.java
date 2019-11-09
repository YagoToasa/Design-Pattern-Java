package TestProgramDemo.PatternRealizationDemo;

import java.util.ArrayList;
import java.util.List;
import kitchen.order.merchname.MerchNameFactory;

/**
 * @className: CompositeDemo
 * @author: Kunyu Chen
 * @description:
 * @date:  2019/11/9
 * @version: v1.0
 */

public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("点一份回锅肉套餐、一份麻婆豆腐套餐和一份水煮鱼套餐！");
        System.out.println("———");

        List<String> list = new ArrayList<String>();
        list.add("回锅肉套餐");
        list.add("麻婆豆腐套餐");
        list.add("水煮鱼套餐");
        List<String> names= null;

        for (int i = 0; i < list.size(); i++) {
            String order = list.get(i);
            names=MerchNameFactory.getMerchName(order);
            //如果点的菜不存在，就会获取到空指针，如果存在，会获取到单品名称的List
            if(names==null){
                System.out.println("没有"+ order);
                System.out.println("———");
            }else{
                System.out.println("您点的"+ list.get(i) +"包括：");
                for(String s:names){
                    System.out.println(s);
                }
                System.out.println("———");
            }
        }
    }

}
