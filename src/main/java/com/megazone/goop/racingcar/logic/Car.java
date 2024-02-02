package com.megazone.goop.racingcar.logic;

public class Car {

    private static final int THRESHOLD_VALUE = 4;
    private static final int DISTANCE_PER_ROUND = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String name;
    private int totalDistance = 0;

    public Car(String name) {
        this.name = name.substring(0, Math.min(name.length(), CAR_NAME_MAX_LENGTH));
    }

    public String getName() {
        return name;
    }

    public int move(int randValue) {
        if ((randValue >= THRESHOLD_VALUE)) {
            totalDistance += DISTANCE_PER_ROUND;
            return DISTANCE_PER_ROUND;
        }

        return 0;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void resetTotalDistance() {
        totalDistance = 0;
    }
}
