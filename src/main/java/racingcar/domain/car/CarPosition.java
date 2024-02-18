package racingcar.domain.car;

public class CarPosition {
    private static final int MIN_VALUE = 0;

    private int position;

    public CarPosition(int position) {
        validatePosition(position);
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    private void validatePosition(int position){
        if (position < MIN_VALUE) {
            throw new RuntimeException("Only positive numbers are allowed");
        }
    }
}
