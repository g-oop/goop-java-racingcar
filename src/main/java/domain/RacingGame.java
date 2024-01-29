package domain;

import java.util.ArrayList;
import java.util.List;

import ui.InputResult;
import ui.OutputResult;


public class RacingGame {

    private final List<Car> cars;
    private static final int RANGE_NUMBER = 10;
    private final InputResult inputResult;
    private final OutputResult outputResult;


    public RacingGame(InputResult inputResult, OutputResult outputResult) {
        this.cars = new ArrayList<>();
        this.inputResult = inputResult;
        this.outputResult = outputResult;
    }

    public void play(InputResult inputResult, OutputResult outputResult) {
        int carCount = inputResult.getCarCount();
        int tryCount = inputResult.getTryCount();
        initializeCars(carCount);
        outputResult.printMessage("\n실행 결과:");
        moveCars(tryCount);
    }


    public void initializeCars(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    private void moveCars(int tryCount) {
        for (int move = 0; move < tryCount; move++) {
            extracted(RANGE_NUMBER);
            outputResult.printCarStates(cars);
        }
    }

    private void extracted(int randomNumber) {
        for (Car car: cars) {
            car.move(randomNumber);
        }
    }


}
