package calculator;

import java.util.HashMap;

/**
 * @className: AddExpression
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class AddExpression extends SymbolExpression {

    public AddExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    // 把左右两个表达式运算的结果加起来
    public int interprete(HashMap<String, Integer> var) {
        return super.left.interprete(var) + super.right.interprete(var);
    }
}