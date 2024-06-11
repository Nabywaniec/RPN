import java.util.Map;
import java.util.Stack;

public class ArgumentOperationStrategy {
    private static final Map<String, Operator> OPERATORS = Map.of(
            "+", Operator.ADD,
            "-", Operator.REMOVE,
            "x", Operator.MULTIPLY,
            "/", Operator.DIVIDE,
            "a", Operator.ABS,
            "m", Operator.MAX);
    private final SingleArgumentOperation singleArgumentOperation;
    private final PairArgumentOperation pairArgumentOperation;
    private final MultipleArgumentOperation multipleArgumentOperation;


    public ArgumentOperationStrategy(
            final SingleArgumentOperation singleArgumentOperation,
            final PairArgumentOperation pairArgumentOperation,
            final MultipleArgumentOperation multipleArgumentOperation) {
        this.singleArgumentOperation = singleArgumentOperation;
        this.pairArgumentOperation = pairArgumentOperation;
        this.multipleArgumentOperation = multipleArgumentOperation;
    }

    public Double calculate(
            final Token tokenOperator,
            final Stack<Double> numbersToCalculate) {
        final Operator operator = OPERATORS.get(tokenOperator.getValue());

        if (operator.isSingleArgumentOperator()) {
            return singleArgumentOperation.calculate(numbersToCalculate, operator);
        } else if (operator.isPairArgumentOperator()) {
            return pairArgumentOperation.calculate(numbersToCalculate, operator);
        } else if (operator.isMultipleArgumentOperator()) {
            return multipleArgumentOperation.calculate(numbersToCalculate, operator);
        }

        throw new RuntimeException();
    }
}
