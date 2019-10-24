package decoration.visitor;

import decoration.furniture.*;

/**
 * @className: WinterVisitor
 * @author: Siqian Wu
 * @description: 给家具换上冬季装扮
 * @designPattern: Visitor
 * @date: 16:14 2019-10-24
 * @version: v1.0
 */
public class WinterVisitor implements FurnitureVisitor{
    /**
     * 将家具换成暖色系
     *
     * @methodName: warmColor
     * @param: [furniture]
     * @Return: void
     */
    private void warmColor(Furniture furniture){
        System.out.println("冬天到了。\n成功换成暖色系"+furniture.getName()+"。");
    }

    /**
     * 摆放暖和的靠背以及坐垫
     *
     * @methodName: setWarmSet
     * @param: []
     * @Return: void
     */
    private void setWarmSet(Chair fur) {
        fur.setBackrest("暖和的靠背");
        fur.setCushion("法兰绒坐垫");
        System.out.println("成功换上"+fur.getAttribute()+"。");
    }

    /**
     * 换上桌子的冬季装扮
     *
     * @methodName: decorateDesk
     * @param: [fur]
     * @Return: void
     */
    private void decorateDesk(Desk fur) {
        fur.setCenterpiece("冬季限定玩偶花束");
        fur.setTablecloth("保暖桌布");
        System.out.println("成功换上"+fur.getAttribute()+"。");
    }

    @Override
    public void visit(Chair fur) {
        warmColor(fur);
        setWarmSet(fur);
        System.out.println("-----");
    }

    @Override
    public void visit(Desk fur) {
        warmColor(fur);
        decorateDesk(fur);
        System.out.println("-----");
    }
}
