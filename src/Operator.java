import java.util.Set;

public enum Operator {
    ADD,
    REMOVE,
    MULTIPLY,
    DIVIDE,
    ABS,
    MAX;

    public boolean isSingleArgumentOperator() {
        return this == ABS;
    }

    public boolean isPairArgumentOperator() {
        return Set.of(ADD, REMOVE, MULTIPLY, DIVIDE).contains(this);
    }

    public boolean isMultipleArgumentOperator() {
        return this == MAX;
    }
}
