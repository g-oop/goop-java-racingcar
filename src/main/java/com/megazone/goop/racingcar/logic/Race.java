package com.megazone.goop.racingcar.logic;

import java.util.ArrayList;

public class Race {

    private ArrayList<Car> cars;

    private int currentRound = 0;

    public Race(int carCount) {
        joinCars(carCount);
    }

    public void startRace(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(Car::move);
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
