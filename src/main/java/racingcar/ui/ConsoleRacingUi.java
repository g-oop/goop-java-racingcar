package racingcar.ui;

import racingcar.entry.Car;
import racingcar.racing.*;

import java.util.Scanner;

public class ConsoleRacingUi implements RacingUi {

    private static final String CAR_START_UNIT = "|";
    private static final String CAR_POSITION_UNIT = "-";

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
    public void showResult(RacingResult result) {
        for (RacingEntries entries: result.getRacingEntriesList()) {
            for (Car car: entries.getEntries()) {
                int position = car.currentPosition();
                println(CAR_START_UNIT + CAR_POSITION_UNIT.repeat(position));
            }
            println();
        }
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void println() {
        print(System.lineSeparator());
    }

    private static void println(String s) {
        print(s + System.lineSeparator());
    }
}
