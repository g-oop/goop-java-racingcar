package com.megazone.goop.racingcar.logic;

public class Car {

    private static final int THRESHOLD_VALUE = 4;
    private static final int DISTANCE_PER_ROUND = 1;

    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return name;
    }

    public int move(int randValue) {
        if ((randValue >= THRESHOLD_VALUE)) {
            position += DISTANCE_PER_ROUND;
            return DISTANCE_PER_ROUND;
        }

        return 0;
    }

    public int getPosition() {
        return position;
    }

    public void resetPosition() {
        position = 0;
    }
}
