package decoration.visitor;

/**
 * @interfaceName: FurnitureAcceptor
 * @author: Siqian Wu
 * @description: 作为访问者模式中的acceptor，接收visitor来操作实现类
 * @designPattern: Visitor
 * @date: 16:16 2019-10-24
 */
public interface FurnitureAcceptor {
    void accept(FurnitureVisitor furVisitor);
}