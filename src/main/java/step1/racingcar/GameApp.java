package step1.racingcar;

import step1.racingcar.view.InputView;

public class GameApp {

    public static void main(String[] args) {
        CarManager carManager = new CarManager(InputView.getCarNames());
        carManager.readyToStart();
        carManager.startGame(InputView.getTryCount());
    }
}
