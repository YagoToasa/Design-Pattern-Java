package decoration.furniture;

import decoration.visitor.FurnitureVisitor;

/**
 * @className: Chair
 * @author: Siqian Wu
 * @description: 家具椅子类
 * @date: 10:09 2019-10-23
 * @version: v1.0 版本
 */
public class Chair extends Furniture{
    public Chair() {
        super("椅子");
    }
    public Chair(String material){ super(material+"椅子");}

    private String cushion;   //坐垫
    private String backrest;  //靠背

    public void setCushion(String cushion) {
        this.cushion = cushion;
    }
    public void setBackrest(String backrest) {
        this.backrest = backrest;
    }

    @Override
    public String getAttribute() {
        return cushion +"与"+ backrest;
    }

    /**
     * 作为Visitor模式中的接受者, 接收访问者
     *
     * @methodName: accept
     * @param: [furVisitor]
     * @Return: void
     */
    @Override
    public void accept(FurnitureVisitor furVisitor) {
        furVisitor.visit(this);
    }
}