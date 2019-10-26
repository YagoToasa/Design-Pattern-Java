package calculator;

import java.util.HashMap;
import java.util.Stack;

/**
 * @className: Calculator
 * @description: 解释器类
 * @author: Liwen Zhu
 * @date: 19:51 2019/10/26
 * @version: v1.0
 */
public class Calculator {

    private AbstractExpression expression;

    /**
     * 对公式进行解析操作
     *
     * @param expStr
     *            输入的公式
     */
    public Calculator(String expStr) {
        // 定义一个堆栈，安排运算的先后顺序
        Stack<AbstractExpression> stack = new Stack<AbstractExpression>();
        // 表达式拆分为字符数组
        char[] charArray = expStr.toCharArray();
        // 运算
        AbstractExpression left = null;
        AbstractExpression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+': // 加法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;

                case '-': // 减法
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default: // 公式中的变量
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
            }
        }
        // 把运算结果抛出来
        this.expression = stack.pop();
    }

    // 计算结果
    public int calculate(HashMap<String, Integer> var) {
        return this.expression.interprete(var);
    }
}