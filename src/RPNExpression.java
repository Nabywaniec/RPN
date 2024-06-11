import java.util.Arrays;
import java.util.List;

public class RPNExpression {
    private static final String DELIMITER = " ";

    private final List<Token> tokens;

    public RPNExpression(final String expressionAsString) {
        this.tokens = Arrays.stream(expressionAsString.split(DELIMITER)).map(Token::new).toList();
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
