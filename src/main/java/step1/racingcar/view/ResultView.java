package step1.racingcar.view;

import step1.racingcar.CarManager;

public class ResultView {

    public static void printResult(CarManager carManager, int tryCount) {
        printReadyToStart(carManager);
        printMoveResult(carManager, tryCount);
    }

    public static void printReadyToStart(CarManager carManager) {
        System.out.println("실행 결과");
        carManager.getPositions().forEach(ResultView::drawMoveStatus);
        System.out.println();
    }

    public static void printMoveResult(CarManager carManager, int tryCount) {
        carManager.moveCars(tryCount).forEach(positions -> {
            positions.forEach(ResultView::drawMoveStatus);
            System.out.println();
        });
    }

    public static void drawMoveStatus(int position) {
        System.out.println("-".repeat(position));
    }

}
