import java.util.List;
import java.util.Stack;

public class Calculator {
    private final ArgumentOperationStrategy strategy;

    public Calculator(final ArgumentOperationStrategy strategy) {
        this.strategy = strategy;
    }

    public Double calculate(final Expression expression) {
        final List<Token> tokens = expression.getTokens();
        final Stack<Double> stack = new Stack<>();

        for (final Token token : tokens) {
            if (token.isNumber()) {
                stack.push(Double.valueOf(token.getValue()));
            } else {
                final Double calculated = strategy.calculate(token, stack);
                stack.push(calculated);
            }
        }
        return stack.pop();
    }
}
