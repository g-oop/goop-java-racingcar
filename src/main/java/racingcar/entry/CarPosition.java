package racingcar.entry;

public class CarPosition {

    private int position;

    public CarPosition() {
        this.position = 0;
    }

    public CarPosition(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int current() {
        return position;
    }
}
