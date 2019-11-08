package TestProgramDemo.PatternRealizationDemo;

import java.util.ArrayList;
import java.util.List;
import kitchen.order.merchname.MerchNameFactory;

/**
 * @className: NullObjectDemo
 * @author: Kunyu Chen
 * @description:
 * @date:  2019/11/9
 * @version: v1.0
 */
public class NullObjectDemo {
    public static void main(String[] args) {
        System.out.println("点一份回锅肉和一份鸡蛋汤！");
        System.out.println("———");

        List<String> list = new ArrayList<String>();
        list.add("回锅肉");
        list.add("鸡蛋汤");
        List<String> names= null;

        for (int i = 0; i < list.size(); i++) {
            String order = list.get(i);
            names=MerchNameFactory.getMerchName(order);
            //如果点的菜不存在，就会获取到空指针，如果存在，会获取到单品名称的List
            if(names==null){
                System.out.print("我们没有");
                System.out.println(order);
            }else{
                System.out.println("您点的菜包括：");
                for(String s:names){
                    System.out.println(s);
                }
            }
        }
    }
}
