package step1.racingcar;

import step1.racingcar.view.InputView;
import step1.racingcar.view.ResultView;

public class GameApp {

    public static void main(String[] args) {
        CarManager carManager = new CarManager(InputView.getCarCount(), InputView.getTryCount());
        carManager.readyToStart();
        ResultView.printResult(carManager);
    }
}
