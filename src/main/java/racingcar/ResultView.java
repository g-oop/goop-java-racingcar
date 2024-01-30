package racingcar;

import java.util.List;

public class ResultView {

    public static void printResult(int[] odometerList) {

        for (int o : odometerList) {
            System.out.print('-');
            for (int b = 0; b < o; b++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }
}
