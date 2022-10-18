package Lab2;

public class LargeMatrixException extends Exception {
    public LargeMatrixException() {
    }

    public LargeMatrixException(String message) {
        super(message);
    }

    public LargeMatrixException(String message, Throwable cause) {
        super(message, cause);
    }

    public LargeMatrixException(Throwable cause) {
        super(cause);
    }

    public LargeMatrixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
