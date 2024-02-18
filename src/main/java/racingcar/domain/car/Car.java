package racingcar.domain.car;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private final CarPosition position;

    public Car(String name) {
        this(name, 0);
    }

    private Car(String name, int position) {
        this.name = new CarName(name);
        this.position = new CarPosition(position);
    }

    public void move(int number) {
        if (isMovable(number)) {
            position.increase();
        }
    }

    public String getName() {
        return name.name();
    }

    public int getPosition() {
        return position.getPosition();
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

}
