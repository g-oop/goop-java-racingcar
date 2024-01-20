package step1;

import step1.view.InputView;
import step1.view.ResultView;
import step1.vo.Cars;

public class GameApp {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();
        Cars cars = CarManager.createCar(carCount);
        ResultView.printExecutionResult(carCount);
        CarManager.move(cars, tryCount);
    }
}
