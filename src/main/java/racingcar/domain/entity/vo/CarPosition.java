package racingcar.domain.entity.vo;

public class CarPosition {
    private static final int MIN_VALUE = 0;

    private int position;

    public CarPosition(int value) {
        validatePosition(value);
        this.position = value;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    private void validatePosition(int value){
        if (value < MIN_VALUE) {
            throw new RuntimeException("Only positive numbers are allowed");
        }
    }
}
