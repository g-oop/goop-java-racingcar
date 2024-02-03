package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import domain.Car;
import strategy.NumberGenerator;

import static ui.OutputResult.printCarsNameLocation;


public class RacingGame {

    private final List<Car> cars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator, String[] carNames) {
        this.numberGenerator = numberGenerator;
        initializeCars(carNames);
    }

    private void initializeCars(String[] carNames) {
        for (String i: carNames) {
            cars.add(new Car(i));
        }
    }

    public List<String> play(int tryCount) {
        moveCars(tryCount);
        return determineWinner(cars);
    }


    private void moveCars(int tryCount) {
        for (int move = 0; move < tryCount; move++) {
            moveAccordingRandomValues();
            printCarsNameLocation(cars);
        }
    }

    private void moveAccordingRandomValues() {
        for (Car car: cars) {
            int randomValue = numberGenerator.generateRandomValue();
            car.move(randomValue);
        }
    }

    private List<String> determineWinner(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}
