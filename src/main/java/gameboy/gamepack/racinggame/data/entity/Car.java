package gameboy.gamepack.racinggame.data.entity;

import java.util.Random;

import gameboy.gamepack.racinggame.data.vo.*;

public class Car {

    private static final int MOVE_RANGE = 10;
    private static final int MOVE_MIN = 4;

    private Random random;
    private Name name;
    private Position position;

    public Car() {
        this(new Name(), new Position(), new Random());
    }

    public Car(Random random) {
        this(new Name(), new Position(), random);
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

    public void run() {
        if (isPushAccelerator()) {
            position.addOne();
        }
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }

    private boolean isPushAccelerator() {
        return random.nextInt(MOVE_RANGE) >= MOVE_MIN;
    }

    public boolean isWin(int winnerPosition) {
        return getPosition() >= winnerPosition;
    }
}
