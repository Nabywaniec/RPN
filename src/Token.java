public class Token {
    private final String value;

    public Token(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public boolean isNumber() {
        try {
            Double.parseDouble(this.value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
