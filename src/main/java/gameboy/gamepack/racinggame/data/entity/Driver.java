package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

public class Driver {

    private final Random random = new Random();
    private final int MOVE_RANGE = 10;
    private final int MOVE_MIN = 4;
    private Car car;

    public Driver() {
        this.car = new Car();
    }

    public int drive() {
        if (isPushAccelerator()) {
            car.run();
        }
        return car.getPosition();
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }
}
