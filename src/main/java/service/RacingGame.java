package service;

import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import domain.Cars;
import strategy.NumberGenerator;

import static domain.Cars.getCarList;
import static view.OutputResult.printCarsNameLocation;


public class RacingGame {


    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator, Cars cars, String[] carNames) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
        initializeCars(carNames);
    }

    private void initializeCars(String[] carNames) {
        for (String i: carNames) {
            cars.addCar(i);
        }
    }

    public List<String> play(int tryCount) {
        moveCars(tryCount);
        return determineWinner();
    }


    private void moveCars(int tryCount) {
        for (int move = 0; move < tryCount; move++) {
            moveAccordingRandomValues();
            printCarsNameLocation(getCarList());
        }
    }

    private void moveAccordingRandomValues() {
        for (Car car: getCarList()) {
            int randomValue = numberGenerator.generateRandomValue();
            car.move(randomValue);
        }
    }

    private List<String> determineWinner() {
        int maxPosition = getCarList().stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return getCarList().stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}
