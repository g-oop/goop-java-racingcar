package domain.vo;

public class Position {

    private static final int MIN_VALUE = 0;
    public static final String VALIDATION_MESSAGE_FORMAT = "%d 이상이여야 합니다.";
    private static final String EX_MESSAGE = String.format(VALIDATION_MESSAGE_FORMAT, MIN_VALUE);

    private int value;

    public Position(int position) {
        validatePosition(position);
        this.value = position;
    }

    public int getValue() {
        return value;
    }

    private static void validatePosition(int position) {
        if (!isValid(position)) {
            throw new IllegalArgumentException(EX_MESSAGE);
        }
    }

    private static boolean isValid(int position) {
        return position >= MIN_VALUE;
    }

    public void increase() {
        value++;
    }

}
