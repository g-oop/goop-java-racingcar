package step1.racingcar.domain.vo;

public class CarPosition {

    private int position;
    private static final int INIT_POSITION = 1;

    public CarPosition() {
        this.position = INIT_POSITION;
    }

    public int getPosition() {
        return this.position;
    }

    public void addPosition() {
        this.position++;
    }
}
