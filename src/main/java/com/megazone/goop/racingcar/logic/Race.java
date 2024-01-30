package com.megazone.goop.racingcar.logic;

import java.util.List;

import com.megazone.goop.racingcar.ui.ResultView;

public class Race {

    private static final int MAX_RANDOM_VALUE = 10;

    private final ResultView resultView;
    private final RandomGenerator randomGenerator;
    private final List<Car> cars;

    private int currentRound = 0;

    public Race(List<Car> cars, ResultView resultView, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.resultView = resultView;
        this.randomGenerator = randomGenerator;
    }

    public void startRace(int roundCount) {
        readyRace();

        resultView.startDisplay();

        for (int i = 0; i < roundCount; i++) {
            cars.forEach(c -> c.move(randomGenerator.getRandomValue(MAX_RANDOM_VALUE)));

            resultView.displayPositions(cars);

            currentRound++;
        }
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    public void endRace() {
        int maxPosition = cars.stream()
            .map(Car::getTotalDistance)
            .max(Integer::compare)
            .orElse(0);

        List<Car> winners = cars.stream()
            .filter(c -> c.getTotalDistance() >= maxPosition)
            .toList();

        resultView.displayWinners(winners);
    }

    private void readyRace() {
        this.currentRound = 0;

        cars.forEach(Car::resetTotalDistance);
    }
}
