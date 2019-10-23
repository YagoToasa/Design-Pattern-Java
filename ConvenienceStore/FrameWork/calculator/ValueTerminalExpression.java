package calculator;

/**
 * @className: ValueTerminalExpression
 * @author: Shidan Cheng
 * @description: 数字终结符解释器
 * @designPattern: Interpreter
 * @date: 9:04 上午 2019/10/23
 * @version: v1.0
 */
public class ValueTerminalExpression implements AbstractExpression {
    private int num;

    public ValueTerminalExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpreter() {
        return this.num;
    }
}
