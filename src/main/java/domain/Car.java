package domain;

public class Car {

    private static final int MIN_VALUE = 4;
    private static final int MAX_LENGTH = 5;
    public static final String VALIDATION_MESSAGE_FORMAT = "길이는 %d를 초과할수없습니다.";

    private static final String EX_MESSAGE = String.format(VALIDATION_MESSAGE_FORMAT, MAX_LENGTH);


    private int position;
    private String name;


    public Car() {
        this.position = 0;
    }

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    private void validateName(String name) {
        if (isValid(name)) {
            throw new IllegalArgumentException(EX_MESSAGE);
        }
    }

    public static boolean isValid(String name) {
        return name.length() > MAX_LENGTH;
    }


    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= MIN_VALUE) {
            position++;
        }
    }


}
