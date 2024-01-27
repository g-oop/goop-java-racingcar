package step1.racingcar;

import step1.racingcar.view.InputView;
import step1.racingcar.view.ResultView;

public class GameApp {

    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();
        CarManager carManager = new CarManager(carCount, tryCount);
        carManager.readyToStart();
        ResultView.printResult(carManager);
    }
}
