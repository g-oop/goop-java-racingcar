package racingcar;

import java.util.Arrays;

public class ResultView {

    public static void printResult(int[] cars) {

        for (int c : cars) {
            System.out.print('-');
            for (int b = 0; b < c; b++) {
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }
}
