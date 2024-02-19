package racingcar.step3;

import java.util.Random;

public class Car {

    private int position = 0;
    private final static Random random = new Random();

    public void move() {
        if (random.nextInt(10) >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
