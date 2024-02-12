package racingcar.domain.car;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }


    public void move(int number) {
        if (isMovable(number)) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }

}
