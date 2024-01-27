package step1.racingcar.view;

import step1.racingcar.CarManager;

public class ResultView {

    public static void printResult(CarManager carManager) {
        printReadyToStart(carManager);
        printMoveResult(carManager);
    }

    public static void printReadyToStart(CarManager carManager) {
        System.out.println("실행 결과");
        carManager.getPositions()
            .forEach(ResultView::drawMoveStatus);
        System.out.println();
    }

    public static void printMoveResult(CarManager carManager) {
        for (int i = 0; i < 5; i++) {
            carManager.moveCars()
                .forEach(ResultView::drawMoveStatus);
            System.out.println();
        }
    }

    public static void drawMoveStatus(int position) {
        System.out.println("-".repeat(position));
    }

}
