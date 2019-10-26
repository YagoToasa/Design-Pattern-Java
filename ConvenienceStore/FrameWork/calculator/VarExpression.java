package calculator;

import java.util.HashMap;

/**
 * @className: VarExpression
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class VarExpression implements AbstractExpression {

    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    public int interprete(HashMap<String, Integer> var) {
        return (Integer) var.get(this.key);
    }
}