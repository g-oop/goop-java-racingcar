package domain;

import java.util.*;

import domain.ui.InputProvider;
import domain.ui.OutputProvider;


public class RacingGame implements Game {

    private final List<Car> cars;
    private final InputProvider inputProvider;
    private final OutputProvider outputProvider;
    private static final int RANGE_NUMBER = 10;


    public RacingGame(InputProvider inputProvider, OutputProvider outputProvider) {
        this.cars = new ArrayList<>();
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
    }

    public void play() {
        int carCount = inputProvider.getCarCount();
        int tryCount = inputProvider.getTryCount();
        initializeCars(carCount);
        outputProvider.printMessage("\n실행 결과:");
        moveCars(tryCount);
        outputProvider.printCarStates(cars);
    }


    public void initializeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void moveCars(int tryCount) {
        for (int move = 0; move < tryCount; move++) {
            int randomNumber = generateRandom(RANGE_NUMBER);
            for (Car car: cars) {
                car.move(randomNumber);
            }
            outputProvider.printCarStates(cars);
        }
    }

    private int generateRandom(int number) {
        return new Random().nextInt(number);
    }


}
