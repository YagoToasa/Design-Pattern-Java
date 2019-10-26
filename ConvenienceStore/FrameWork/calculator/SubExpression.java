package calculator;

import java.util.HashMap;

/**
 * @className: SubExpression
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class SubExpression extends SymbolExpression {

    public SubExpression(AbstractExpression left, AbstractExpression right) {
        super(left, right);
    }

    // 左右两个表达式相减
    public int interprete(HashMap<String, Integer> var) {
        return super.left.interprete(var) - super.right.interprete(var);
    }
}