package step1.racingcar;

import step1.racingcar.view.InputView;
import step1.racingcar.view.ResultView;

public class GameApp {

    public static void main(String[] args) {
        int carCount = 0;
        int tryCount = 0;
        try {
            carCount = InputView.getCarCount();
            tryCount = InputView.getTryCount();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값이 입력되었습니다.");
            System.exit(0);
        }
        CarManager carManager = new CarManager(carCount, tryCount);
        carManager.readyToStart();
        ResultView.printResult(carManager);
    }
}
