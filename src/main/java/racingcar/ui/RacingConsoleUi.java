package racingcar.ui;

import racingcar.entry.Car;
import racingcar.racing.*;

import java.util.Scanner;

public class RacingConsoleUi implements RacingUi {

    public static final String CAR_START_UNIT = "|";
    public static final String CAR_POSITION_UNIT = "-";

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public RacingPreference inputPreference() {
        int carCount = scanInt("자동차 대수는 몇 대인가요? ");
        int moveCount = scanInt("시도할 횟수는 몇 회인가요? ");
        return new RacingPreference(carCount, moveCount);
    }

    private static int scanInt(String title) {
        print(title);
        return SCANNER.nextInt();
    }

    @Override
    public void showStatus(RacingGame racingGame) {
        RacingEntries racingEntries = racingGame.getRacingEntries();
        for (Car car: racingEntries.getEntries()) {
            int position = car.currentPosition();
            print(CAR_START_UNIT);
            for (int i = 0; i < position; i++) {
                print(CAR_POSITION_UNIT);
            }
            println();
        }
        println();
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void println() {
        print(System.lineSeparator());
    }
}
