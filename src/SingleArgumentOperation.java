public class SingleArgumentOperation {

    public Double calculate(
            final Double argument,
            final Operator operator) {
        if (operator == Operator.ABS) {
            return Math.abs(argument);
        }
        throw new RuntimeException();
    }
}
