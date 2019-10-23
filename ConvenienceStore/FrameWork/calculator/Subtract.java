package calculator;

/**
 * @className: Subtract
 * @author: Shidan Cheng
 * @description: 减法解释器
 * @designPattern: Interpreter
 * @date: 9:15 上午 2019/10/23
 * @version: v1.0
 */
public class Subtract extends OperationNonterminalExpression {
    Subtract(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpreter() {
        return leftExpression.interpreter() - rightExpression.interpreter();
    }
}
