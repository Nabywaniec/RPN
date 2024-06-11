import java.util.Map;
import java.util.Stack;

import operator.AbsOperator;
import operator.AddOperator;
import operator.ArgumentOperator;
import operator.DivideOperator;
import operator.MaxOperator;
import operator.MultiplyOperator;
import operator.SubstractOperator;

public class ArgumentOperationStrategy {
    private static final Map<String, ArgumentOperator> OPERATORS = Map.of(
            "+", new AddOperator(),
            "-", new SubstractOperator(),
            "x", new MultiplyOperator(),
            "/", new DivideOperator(),
            "a", new AbsOperator(),
            "m", new MaxOperator());

    public ArgumentOperationStrategy() {}

    public Double calculate(
            final Token tokenOperator,
            final Stack<Double> numbersToCalculate) {
        if (!OPERATORS.containsKey(tokenOperator.getValue())) {
            throw new RuntimeException();
        }
        final ArgumentOperator operator = OPERATORS.get(tokenOperator.getValue());
        return operator.calculate(numbersToCalculate);
    }
}
