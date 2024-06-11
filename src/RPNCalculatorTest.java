import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RPNCalculatorTest {
    private final RPNCalculator RPNCalculator = new RPNCalculator(new ArgumentOperationStrategy());

    @ParameterizedTest
    @MethodSource("sentenceWithCalculatedResult")
    void should_calculate(
            final String expression,
            final Double result) {
        // given
        final RPNExpression sentence = new RPNExpression(expression);

        // when
        Double calculated = RPNCalculator.calculate(sentence);

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