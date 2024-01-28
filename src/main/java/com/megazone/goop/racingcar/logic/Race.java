package com.megazone.goop.racingcar.logic;

import java.util.ArrayList;
import java.util.List;

import com.megazone.goop.racingcar.ui.ResultView;

public class Race {

    private static final int MAX_RANDOM_VALUE = 10;

    private final ResultView resultView;
    private final RandomGenerator randomGenerator;
    private List<Car> cars;

    private int currentRound = 0;

    public Race(ResultView resultView, RandomGenerator randomGenerator, int carCount) {
        this.resultView = resultView;
        this.randomGenerator = randomGenerator;

        joinCars(carCount);
    }

    private void joinCars(int carCount) {
        this.cars = new ArrayList<>();

        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void startRace(int roundCount) {
        readyRace();

        resultView.startDisplay();

        for (int i = 0; i < roundCount; i++) {
            cars.forEach(c -> c.move(randomGenerator.getRandomValue(MAX_RANDOM_VALUE)));

            resultView.displayPositions(cars.stream().map(Car::getTotalDistance).toList());

            currentRound++;
        }
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    private void readyRace() {
        this.currentRound = 0;

        cars.forEach(Car::resetTotalDistance);
    }
}
