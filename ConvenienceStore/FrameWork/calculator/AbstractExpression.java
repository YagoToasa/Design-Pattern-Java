package calculator;

import java.util.HashMap;

/**
 * @className: AbstractExpression
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public interface AbstractExpression {

    // 每个表达式都必须有一个解释操作
    public int interprete(HashMap<String, Integer> var);

}