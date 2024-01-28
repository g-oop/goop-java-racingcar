package racingcar.ui;

import racingcar.entry.Car;
import racingcar.racing.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleRacingUi implements RacingUi {

    private static final String CAR_POSITION_UNIT = "-";

    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public RacingPreference inputPreference() {
        String carNames = scanCarNames();
        int moveCount = scanMoveCount();
        return new RacingPreference(splitCarNames(carNames), moveCount);
    }

    private static String scanCarNames() {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). ");
        return SCANNER.next();
    }

    private static int scanMoveCount() {
        print("시도할 횟수는 몇 회인가요? ");
        return SCANNER.nextInt();
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(",");
    }

    @Override
    public void showResult(RacingResult result) {
        for (RacingEntries entries: result.getRacingEntriesHistory()) {
            showResult(entries);
            println();
        }
        showWinners(result);
    }

    private static void showResult(RacingEntries entries) {
        for (Car car: entries.getEntries()) {
            int position = car.currentPosition();
            String name = String.format("%5s", car.getName());
            println(name + ": " + CAR_POSITION_UNIT.repeat(position));
        }
    }

    private static void showWinners(RacingResult result) {
        List<String> winnerCarNames = result.getWinners()
            .stream()
            .map(Car::getName)
            .toList();
        println(String.format("최종 우승자: %s", String.join(", ", winnerCarNames)));
    }

    private static void println() {
        print(System.lineSeparator());
    }

    private static void println(String s) {
        print(s + System.lineSeparator());
    }

    private static void print(String s) {
        System.out.print(s);
    }
}
