package racingcar.step345;

import java.util.List;

public class ResultView {

    public static void printResult(int[] odometerList) {

        for (int odometer : odometerList) {
            System.out.print('-');
            for (int b = 0; b < odometer; b++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }
}
