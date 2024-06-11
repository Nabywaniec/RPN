public class PairArgumentOperation {

    public Double calculate(
            final Double firstArgument,
            final Double secondArgument,
            final Operator operator) {
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
