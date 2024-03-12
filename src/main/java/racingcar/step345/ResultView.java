package racingcar.step345;

public class ResultView {

    public static void printResult(int[][] laps) {

        for (int[] odometerList: laps) {
            for (int odometer: odometerList) {
                System.out.print('-');
                for (int b = 0; b < odometer; b++) {
                    System.out.print('-');
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
