import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class
CalculatorTest {
    private final Calculator calculator = new Calculator(new ArgumentOperationStrategy(
            new SingleArgumentOperation(), new PairArgumentOperation(), new MultipleArgumentOperation()));


    @ParameterizedTest
    @MethodSource("sentenceWithCalculatedResult")
    void should_calculate(
            final String expression,
            final Double result) {
        // given
        final Expression sentence = new Expression(expression);

        // when
        Double calculated = calculator.calculate(sentence);

        // then
        assertEquals(result, calculated);
    }


    private static Stream<Arguments> sentenceWithCalculatedResult() {
        return Stream.of(
                Arguments.of("2 3 + 5 x", 25.0),
                Arguments.of("2 30 -1 10 m", 30.0),
                Arguments.of("-2 a 3 + 5 x", 25.0),
                Arguments.of("5 1 2 + 4 x + 3 -", 14.0),
                Arguments.of("2 7 + 3 / 14 3 - 4 x + 2 /", 23.5),
                Arguments.of("12 2 3 4 x 10 5 / + x +", 40.0));
    }

}