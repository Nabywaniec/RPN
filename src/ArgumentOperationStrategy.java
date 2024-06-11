import java.util.ArrayList;
import java.util.List;
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
            return calculateSingleArgumentOperation(numbersToCalculate, operator);
        } else if (operator.isPairArgumentOperator()) {
            return calculatePairArgumentOperation(numbersToCalculate, operator);
        } else if (operator.isMultipleArgumentOperator()) {
            return calculateMultipleArgumentOperation(numbersToCalculate, operator);
        }

        throw new RuntimeException();

    }

    private Double calculateMultipleArgumentOperation(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        List<Double> arguments = new ArrayList<>();
        while (! numbersToCalculate.empty()) {
            arguments.add(numbersToCalculate.pop());
        }
        return multipleArgumentOperation.calculate(arguments, operator);
    }

    private Double calculatePairArgumentOperation(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        final Double firstArgument = numbersToCalculate.pop();
        final Double secondArgument = numbersToCalculate.pop();
        return pairArgumentOperation.calculate(firstArgument, secondArgument, operator);
    }

    private Double calculateSingleArgumentOperation(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        final Double oneArgument = numbersToCalculate.pop();
        return singleArgumentOperation.calculate(oneArgument, operator);
    }
}
