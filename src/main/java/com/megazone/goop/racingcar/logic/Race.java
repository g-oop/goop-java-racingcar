package com.megazone.goop.racingcar.logic;

import java.util.ArrayList;

public class Race {

    private static final int MAX_RANDOM_VALUE = 10;

    private final RandomGenerator randomGenerator;
    private ArrayList<Car> cars;

    private int currentRound = 0;

    public Race(RandomGenerator randomGenerator, int carCount) {
        this.randomGenerator = randomGenerator;

        joinCars(carCount);
    }

    public void startRace(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(c -> c.move(randomGenerator.getRandomValue(MAX_RANDOM_VALUE)));
            currentRound++;
        }
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    private void joinCars(int carCount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
}
