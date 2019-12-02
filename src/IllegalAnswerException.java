public class IllegalAnswerException extends IllegalArgumentException {
    public IllegalAnswerException() {
        super("Not a valid answer.");
    }
}
