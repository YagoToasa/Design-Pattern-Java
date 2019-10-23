package calculator;

/**
 * @className: Add
 * @author: Shidan Cheng
 * @description: 加法解释器
 * @designPattern: Interpreter
 * @date: 9:04 上午 2019/10/23
 * @version: v1.0
 */
public class Add extends OperationNonterminalExpression {

    Add(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int interpreter() {
        return leftExpression.interpreter() + rightExpression.interpreter();
    }
}
