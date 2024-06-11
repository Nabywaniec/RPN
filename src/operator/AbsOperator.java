package operator;

import java.util.Stack;

public class AbsOperator implements ArgumentOperator {
    @Override
    public Double calculate(final Stack<Double> numbersToCalculate) {
        final Double argument = numbersToCalculate.pop();
        return Math.abs(argument);
    }
}
