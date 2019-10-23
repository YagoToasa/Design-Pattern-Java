package calculator;

/**
 * @className: OperationNonterminalExpression
 * @description: 操作符非终结符
 * @author: Shidan Cheng
 * @date: 9:08 上午 2019/10/23
 * @version: v1.0
 */
public abstract class OperationNonterminalExpression implements AbstractExpression {

    protected AbstractExpression leftExpression;
    protected AbstractExpression rightExpression;

    OperationNonterminalExpression(AbstractExpression leftExpression, AbstractExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }
}
