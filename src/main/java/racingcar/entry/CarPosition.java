package racingcar.entry;

public class CarPosition {

    private final int position;

    public CarPosition() {
        this.position = 0;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public int increase() {
        return position + 1;
    }

    public int current() {
        return position;
    }
}
