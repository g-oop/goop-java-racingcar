package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

import gameboy.gamepack.racinggame.data.vo.CarStatus;

public class Driver {

    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;

    private final Random random;
    private Car car;

    public Driver() {
        this(new Random());
    }

    public Driver(String carName) {
        this(new Random(), new Car(carName));
    }

    public Driver(Random random) {
        this(random, new Car());
    }

    public Driver(Random random, Car car) {
        this.random = random;
        this.car = car;
    }

    public void drive() {
        if (isPushAccelerator()) {
            car.run();
        }
    }

    public int getCarPosition() {
        return car.getPosition();
    }

    public CarStatus monitorCarStatus() {
        return new CarStatus(car.getName(), car.getPosition());
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }
}
