package operator;

import java.util.Stack;

public class AddOperator implements ArgumentOperator {
    @Override
    public Double calculate(final Stack<Double> numbersToCalculate) {
        final Double firstArgument = numbersToCalculate.pop();
        final Double secondArgument = numbersToCalculate.pop();
        return secondArgument + firstArgument;
    }
}
