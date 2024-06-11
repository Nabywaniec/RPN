import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MultipleArgumentOperation implements ArgumentOperation {

    @Override
    public Double calculate(
            final Stack<Double> numbersToCalculate,
            final Operator operator) {
        final List<Double> arguments = new ArrayList<>();
        while (!numbersToCalculate.empty()) {
            arguments.add(numbersToCalculate.pop());
        }

        if (operator == Operator.MAX) {
            return maximum(arguments);
        }
        throw new RuntimeException();
    }

    private Double maximum(final List<Double> arguments) {
        Double actualMaximum = arguments.get(0);
        for (Double number : arguments) {
            if (number > actualMaximum) {
                actualMaximum = number;
            }
        }
        return actualMaximum;
    }
}
