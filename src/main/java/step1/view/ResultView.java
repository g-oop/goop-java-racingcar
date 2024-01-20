package step1.view;

public class ResultView {

    public static void printExecutionResult(int carCount) {
        System.out.println("실행 결과");
        printInitialLoc(carCount);
        ResultView.divideProgressStage();
    }

    public static void printInitialLoc(int carCount) {
        for (int i = 0; i < carCount; i++) {
            drawMoveStatus(1);
        }
    }

    public static void divideProgressStage() {
        System.out.println();
    }

    public static void drawMoveStatus(int loc) {
        System.out.println("-".repeat(loc));
    }

}
