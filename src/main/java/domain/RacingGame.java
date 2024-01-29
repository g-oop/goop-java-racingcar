package domain;

import java.util.*;

import ui.InputResult;
import ui.OutputResult;


public class RacingGame {

    private final List<Car> cars;
    private static final int RANGE_NUMBER = 10;


    public RacingGame(InputResult inputProvider, OutputResult outputProvider) {
        this.cars = new ArrayList<>();
        this.inputProvider = inputProvider;
        this.outputProvider = outputProvider;
    }

    public void play(InputResult inputResult, OutputResult outputResult) {
        int carCount = inputResult.getCarCount();
        int tryCount = inputResult.getTryCount();
        initializeCars(carCount);
        outputResult.printMessage("\n실행 결과:");
        moveCars(tryCount);
        outputResult.printCarStates(cars);
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
