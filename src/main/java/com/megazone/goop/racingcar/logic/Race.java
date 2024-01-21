package com.megazone.goop.racingcar.logic;

import java.util.ArrayList;

import com.megazone.goop.racingcar.ui.ResultView;

public class Race {

    private static final int MAX_RANDOM_VALUE = 10;

    private final ResultView resultView;
    private final RandomGenerator randomGenerator;
    private ArrayList<Car> cars;

    private int currentRound = 0;

    public Race(ResultView resultView, RandomGenerator randomGenerator, int carCount) {
        this.resultView = resultView;
        this.randomGenerator = randomGenerator;

        joinCars(carCount);
    }

    public void startRace(int roundCount) {
        for (int i = 0; i < roundCount; i++) {
            cars.forEach(c -> c.move(randomGenerator.getRandomValue(MAX_RANDOM_VALUE)));

            resultView.displayResult(cars.stream().map(Car::getTotalDistance).toList());

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
