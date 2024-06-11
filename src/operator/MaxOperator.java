package operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxOperator implements ArgumentOperator {
    @Override
    public Double calculate(final Stack<Double> numbersToCalculate) {
        final List<Double> arguments = new ArrayList<>();
        while (!numbersToCalculate.empty()) {
            arguments.add(numbersToCalculate.pop());
        }
        return maximum(arguments);
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
