package calculator;

/**
 * @className: Divide
 * @author: Shidan Cheng
 * @description: 除法解释器
 * @designPattern: Interpreter
 * @date: 9:18 上午 2019/10/23
 * @version: v1.0
 */
public class Divide extends OperationNonterminalExpression {

    Divide(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpreter() {
        return leftExpression.interpreter() / rightExpression.interpreter();
    }
}
