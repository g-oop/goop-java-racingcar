package racingcar.entry;

import java.util.Random;

public class Car {

    private final Random random;

    private int position = 0;

    public Car(Random random) {
        this.random = random;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }

    private boolean canMove() {
        int randomValue = random.nextInt(10);
        return randomValue >= 4;
    }
}
