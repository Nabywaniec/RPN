package operator;

import java.util.Stack;

import operator.ArgumentOperator;

public class SubstractOperator implements ArgumentOperator {
    @Override
    public Double calculate(final Stack<Double> numbersToCalculate) {
        final Double firstArgument = numbersToCalculate.pop();
        final Double secondArgument = numbersToCalculate.pop();
        return secondArgument - firstArgument;
    }
}
