package decoration.visitor;

import decoration.furniture.*;

/**
 * @interfaceName: FurnitureVisitor
 * @author: Siqian Wu
 * @description: 作为访问者模式中的visitor
 * @designPattern: Visitor
 * @date: 16:16 2019-10-24
 */
public interface FurnitureVisitor {
    void visit(Chair chair);
    void visit(Desk desk);
}
