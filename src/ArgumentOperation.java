import java.util.Stack;

public interface ArgumentOperation {
    Double calculate(
            final Stack<Double> numbersToCalculate,
            final Operator operator);
}
