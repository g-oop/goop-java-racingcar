package racingcar.view;

import java.util.List;

import racingcar.domain.CarState;
import racingcar.domain.RacingGameState;
import racingcar.domain.RacingGameResult;
import racingcar.domain.entity.car.Car;

public class RacingGameResultView {
    public static void printResult(RacingGameResult result) {
        printEachStatus(result.getGameStateHistory());
    }

    public static void printEachStatus(List<RacingGameState> statuses) {
        for (RacingGameState status : statuses) {
            drawCarPaths(status.carStates());
        }
    }

    private static void drawCarPaths(List<CarState> carStates) {
        for (CarState carState : carStates) {
            drawCarPath(carState);
        }
        System.out.println();
    }

    private static void drawCarPath(CarState carState) {
        System.out.print(carState.name() + "|");

        for (int i = 0; i < carState.position(); i++) {
            System.out.print("-");
        }
        System.out.print("⛟");
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        System.out.println(getWinnerNames(cars) + "가 최종 우승했습니다.");
    }

    private static String getWinnerNames(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).toList();
        return String.join(",", names);
    }


}
