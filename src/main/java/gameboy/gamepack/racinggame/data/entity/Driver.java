package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

public class Driver {

    private final Random random;
    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;
    private Car car;

    public Driver() {
        this.random = new Random();
        this.car = new Car();
    }

    public Driver(Random random) {
        this.random = random;
        this.car = new Car();
    }

    public void drive() {
        if (isPushAccelerator()) {
            car.run();
        }
    }

    public int getCarPosition() {
        return car.getPosition();
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }
}
