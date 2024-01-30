package service;

import java.util.ArrayList;
import java.util.List;

import domain.Car;
import strategy.NumberGenerator;

import static ui.OutputResult.printCarStates;
import static ui.OutputResult.printMessage;


public class RacingGame {

    private final List<Car> cars = new ArrayList<>();
    private static final int RANGE_NUMBER = 10;
    private final NumberGenerator numberGenerator;

    public RacingGame(NumberGenerator numberGenerator, String carNameFromUser) {
        this.numberGenerator = numberGenerator;
        initializeCars(carNameFromUser);
    }

    public void play(int tryCount) {
        printMessage("\n실행 결과:");
        moveCars(tryCount);
    }


    public void initializeCars(String carNameFromUser) {
        String[] carNames = carNameFromUser.split(",");
        for (String carName: carNames) {
            cars.add(new Car(carName));
        }
    }

    private void moveCars(int tryCount) {
        for (int move = 0; move < tryCount; move++) {
            generateRandomValue();
            printCarStates(getCarPositions());
        }
    }

    private void generateRandomValue() {
        for (Car car: cars) {
            int randomValue = numberGenerator.generateRandomValue(RANGE_NUMBER);
            car.move(randomValue);
        }
    }

    private int[] getCarPositions() {
        return cars.stream().mapToInt(Car::getPosition).toArray();
    }
}
