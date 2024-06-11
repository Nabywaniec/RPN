import java.util.List;

public class MultipleArgumentOperation {

    public Double calculate(
            final List<Double> arguments,
            final Operator operator) {
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
