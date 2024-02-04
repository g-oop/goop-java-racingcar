package com.megazone.goop.racingcar.logic;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static final int MAX_RANDOM_VALUE = 10;

    private final RacePlan racePlan;
    private final RandomGenerator randomGenerator;
    private final List<Car> cars;
    private final List<RoundRecord> roundRecords = new ArrayList<>();

    private int currentRound = 0;

    public Race(RacePlan racePlan, RandomGenerator randomGenerator) {
        this.racePlan = racePlan;
        this.randomGenerator = randomGenerator;

        this.cars = racePlan.CarNames().stream()
            .map(n -> new Car(n)).toList();
    }

    public void startRace() {
        readyRace();

        for (int i = 0; i < racePlan.roundCount(); i++) {
            cars.forEach(c -> c.move(randomGenerator.getRandomValue(MAX_RANDOM_VALUE)));

            List<CarDistance> carPositions = cars.stream().map(c ->
                new CarDistance(c.getName().name(), c.getPosition())
            ).toList();

            roundRecords.add(new RoundRecord(carPositions));

            currentRound++;
        }
    }

    public int getCurrentRound() {
        return this.currentRound;
    }

    public List<RoundRecord> getRoundRecords() {
        return this.roundRecords;
    }

    public List<Car> getWinners() {
        int topRecord = getTopRecord();

        return cars.stream()
            .filter(c -> c.getPosition() >= topRecord)
            .toList();
    }

    private void readyRace() {
        this.currentRound = 0;

        cars.forEach(Car::resetPosition);
    }

    private int getTopRecord() {
        return cars.stream()
            .map(Car::getPosition)
            .max(Integer::compare)
            .orElse(0);
    }
}
