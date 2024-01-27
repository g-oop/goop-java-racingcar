package step1.racingcar.view;

import step1.racingcar.CarManager;
import step1.racingcar.RandomUtils;

public class ResultView {

    public static void printResult(CarManager carManager) {
        printReadyToStart(carManager);
        printMoveResult(carManager);
    }

    public static void printReadyToStart(CarManager carManager) {
        System.out.println("실행 결과");
        carManager.getLocs()
            .forEach(ResultView::drawMoveStatus);
        System.out.println();
    }

    public static void printMoveResult(CarManager carManager) {
        //for (int i = 0; i < tryCount; i++) {
        //    carManager.moveCars(10)
        //        .stream()
        //        .peek(ResultView::drawMoveStatus)
        //        .toList();
        //    System.out.println();
        //}
    }

    public static void drawMoveStatus(int loc) {
        System.out.println("-".repeat(loc));
    }

}
