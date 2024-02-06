package step1.racingcar.exception;

public class CarNameException extends RuntimeException {

    public CarNameException(String message) {
        super(message);
    }

    public CarNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
