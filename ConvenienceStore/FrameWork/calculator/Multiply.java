package calculator;

/**
 * @className: Multiply
 * @author: Shidan Cheng
 * @description: 乘法解释器
 * @designPattern: Interpreter
 * @date: 9:15 上午 2019/10/23
 * @version: v1.0
 */
public class Multiply extends OperationNonterminalExpression{
    Multiply(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpreter() {
        return leftExpression.interpreter() * rightExpression.interpreter();
    }
}
