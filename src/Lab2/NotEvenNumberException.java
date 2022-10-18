package Lab2;

public class NotEvenNumberException extends Exception {
    public NotEvenNumberException() {
    }

    public NotEvenNumberException(String message) {
        super(message);
    }

    public NotEvenNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEvenNumberException(Throwable cause) {
        super(cause);
    }

    public NotEvenNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
