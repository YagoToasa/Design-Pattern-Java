package decoration.furniture;

import decoration.visitor.FurnitureVisitor;
/**
 * @className: Desk
 * @author: Siqian Wu
 * @description: 家具桌子类
 * @date: 10:09 2019-10-23
 * @version: v1.0 版本
 */
public class Desk extends Furniture{
    public Desk() {
        super("桌子");
    }
    public Desk(String material){ super(material+"桌子");}

    private String tablecloth;    //桌布
    private String centerpiece;   //桌面摆饰

    public void setTablecloth(String tablecloth) {
        this.tablecloth = tablecloth;
    }
    public void setCenterpiece(String centerpiece) {
        this.centerpiece = centerpiece;
    }

    @Override
    public String getAttribute() {
        return tablecloth +"与"+ centerpiece;
    }
    /**
     * 作为Visitor模式中的接受者, 接收访问者
     *
     * @methodName: accept
     * @param: [furVisitor] 
     * @Return: void
     */
    @Override
    public void accept(FurnitureVisitor furVisitor) { furVisitor.visit(this); }
}