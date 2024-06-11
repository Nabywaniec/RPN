import java.util.Stack;

public class PairArgumentOperation implements ArgumentOperation {

    @Override
    public Double calculate(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        final Double firstArgument = numbersToCalculate.pop();
        final Double secondArgument = numbersToCalculate.pop();
        switch (operator) {
            case ADD:
                return secondArgument + firstArgument;
            case REMOVE:
                return secondArgument - firstArgument;
            case MULTIPLY:
                return secondArgument * firstArgument;
            case DIVIDE:
                return secondArgument / firstArgument;
        }
        throw new RuntimeException();
    }
}
