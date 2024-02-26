package racingcar.domain.entity.vo;

public class CarPosition {
    private static final int MIN_VALUE = 0;

    private int value;

    public CarPosition(int value) {
        validatePosition(value);
        this.value = value;
    }

    public void increase() {
        value++;
    }

    public int getValue() {
        return value;
    }

    private void validatePosition(int position){
        if (position < MIN_VALUE) {
            throw new RuntimeException("Only positive numbers are allowed");
        }
    }
}
