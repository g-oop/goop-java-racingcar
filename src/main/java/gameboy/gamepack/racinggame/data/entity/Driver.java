package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

public class Driver {

    private final Random random = new Random();
    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;
    private Car car;

    public Driver() {
        this.car = new Car();
    }

    public void drive() {
        if (isPushAccelerator()) {
            car.run();
        }
    }

    public Car getCar() {
        return car;
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }
}
