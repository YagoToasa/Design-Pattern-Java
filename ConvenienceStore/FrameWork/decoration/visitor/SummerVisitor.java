package decoration.visitor;

import decoration.furniture.Chair;
import decoration.furniture.Desk;
import decoration.furniture.Furniture;

/**
 * @className: SummerVisitor
 * @author: Siqian Wu
 * @description: 给家具换上夏季装扮
 * @designPattern: Visitor
 * @date: 16:14 2019-10-24
 * @version: v1.0
 */
public class SummerVisitor implements FurnitureVisitor {
    /**
     * 将家具换成冷色系
     *
     * @methodName: coolColor
     * @param: [furniture]
     * @Return: void
     */
    private void coolColor(Furniture furniture){
        System.out.println("夏天到了。\n成功换成冷色系"+furniture.getName()+"。");
    }

    /**
     * 摆放清凉的靠背以及坐垫
     *
     * @methodName: setCoolSet
     * @param: []
     * @Return: void
     */
    private void setCoolSet(Chair fur) {
        fur.setBackrest("清凉的靠背");
        fur.setCushion("竹席坐垫");
        System.out.println("成功换上"+fur.getAttribute()+"。");
    }

    /**
     * 换上桌子的夏日装扮
     *
     * @methodName: decorateDesk
     * @param: [fur] 
     * @Return: void
     */
    private void decorateDesk(Desk fur) {
        fur.setCenterpiece("夏季花瓶");
        fur.setTablecloth("置凉桌布");
        System.out.println("成功换上"+fur.getAttribute()+"。");
    }

    @Override
    public void visit(Chair fur) {
        coolColor(fur);
        setCoolSet(fur);
        System.out.println("-----");
    }

    @Override
    public void visit(Desk fur) {
        coolColor(fur);
        decorateDesk(fur);
        System.out.println("-----");
    }
}
