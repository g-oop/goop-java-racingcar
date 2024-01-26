package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

import gameboy.gamepack.racinggame.data.vo.*;

public class Car {

    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;

    private Random random;
    private Name name;
    private Position position;

    public Car(Name name, Random random) {
        this(name, new Position(), random);
    }

    public Car(Name name) {
        this(name, new Position(), new Random());
    }

    public Car(Name name, Position position) {
        this(name, position, new Random());
    }

    public Car(Name name, Position position, Random random) {
        this.name = name;
        this.position = position;
        this.random = random;
    }

    public static Car copy(Car car) {
        return new Car(
            new Name(car.name.getName()),
            new Position(car.position.value()),
            car.random
        );
    }

    public void run() {
        if (isPushAccelerator()) {
            position.addOne();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }

    public boolean isSamePosition(Position that) {
        return position.equals(that);
    }
}
