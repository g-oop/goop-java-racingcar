package step1.racingcar.view;

import step1.racingcar.CarManager;
import step1.racingcar.RandomUtils;

public class ResultView {

    public static void printResult(CarManager carManager) {
        printReadyToStart(carManager.getCarCount());
        printResult(carManager.getTryCount(), carManager);
    }

    public static void printReadyToStart(int carCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < carCount; i++) {
            drawMoveStatus(1);
        }
        System.out.println();
    }

    public static void printResult(int tryCount, CarManager carManager) {
        for (int i = 0; i < tryCount; i++) {
            carManager.moveCars(RandomUtils.getRandom(10))
                .stream()
                .peek(ResultView::drawMoveStatus)
                .toList();
            System.out.println();
        }
    }

    public static void drawMoveStatus(int loc) {
        System.out.println("-".repeat(loc));
    }

}
