package domain.vo;


public class CarName {

    private static final int MAX_LENGTH = 5;
    public static final String VALIDATION_MESSAGE_FORMAT = "길이는 %d를 초과할수없습니다.";

    private static final String EX_MESSAGE = String.format(VALIDATION_MESSAGE_FORMAT, MAX_LENGTH);

    private String value;

    public CarName(String name) {
        validateName(name);
        this.value = name;
    }

    public String getValue() {
        return value;
    }

    private static void validateName(String name) {
        if (!isValid(name)) {
            throw new IllegalArgumentException(EX_MESSAGE);
        }
    }

    private static boolean isValid(String name) {
        return name.length() <= MAX_LENGTH;
    }


}
