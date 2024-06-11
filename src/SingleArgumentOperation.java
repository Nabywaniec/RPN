import java.util.Stack;

public class SingleArgumentOperation implements ArgumentOperation{

    @Override
    public Double calculate(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        final Double argument = numbersToCalculate.pop();
        if (operator == Operator.ABS) {
            return Math.abs(argument);
        }
        throw new RuntimeException();
    }
}
