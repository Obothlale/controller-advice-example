package co.za.obothlale.exception;

public class NoWorldMentionedToGreetException extends RuntimeException {

    public NoWorldMentionedToGreetException(String message) {
        this(message, null);
    }

    public NoWorldMentionedToGreetException(String message, Throwable cause) {
        super(message, cause);
    }
}
