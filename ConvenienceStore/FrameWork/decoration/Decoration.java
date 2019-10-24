package decoration;

import decoration.furniture.Furniture;

import java.util.ArrayList;
/**
 * @className: Decoration
 * @author: Siqian Wu
 * @description: 装饰类
 * @date: 10:09 2019-10-23
 * @version: v1.0 版本
 */
public class Decoration{
    ArrayList<Furniture> furnitures = new ArrayList<>();
    public Decoration(){}

    static Decoration decoration = new Decoration();
    public static Decoration getDecoration() {
        return decoration;
    }

    /**
     * 将当前家具放入已有家具的登记表中
     *
     * @methodName: addFurniture
     * @param: [furniture]
     * @Return: void
     */
    public void addFurniture(Furniture furniture){
        furnitures.add(furniture);
        System.out.println("成功添加"+furniture.getName());
        System.out.printf("-----");
    }

    /**
     * 将当前家具从已有家具的登记表中移除
     *
     * @methodName: removeFurniture
     * @param: [furniture]
     * @Return: void
     */
    public void removeFurniture(Furniture furniture){
        if (furnitures.isEmpty()){
            System.out.println("目前暂无家具，不可进行删除！");
        }
        else{
            boolean flag=false;
            for(int i=furnitures.size()-1;i>=0;i--){
                if(furnitures.get(i).getName().equals(furniture.getName())){
                    System.out.println("成功移除"+furniture.getName());
                    flag=true;
                    furnitures.remove(i);
                    break;
                    }
                }
            if(!flag){
                System.out.println("当前无可移除的"+furniture.getName());
            }
        }
        System.out.printf("-----");
    }

    /**
     * 显示所有现有家具
     *
     * @methodName: showFurniture
     * @param: []
     * @Return: void
     */
    public void showFurniture(){
        System.out.println("\n"+"现有家具:");
        for(Furniture f:furnitures){
            System.out.println(f.getName());
        }
        if(furnitures.isEmpty())
            System.out.println("目前暂无家具！");
        System.out.println("-----");
    }

}