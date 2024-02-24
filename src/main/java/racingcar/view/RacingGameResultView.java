package racingcar.view;

import java.util.List;

import racingcar.domain.entity.RacingGameResult;
import racingcar.domain.entity.car.Car;
import racingcar.domain.entity.car.Cars;

public class RacingGameResultView {

    public static void printResult(RacingGameResult result) {
        printEachStatus(result.getCarsHistory());
        printWinners(result.getWinners());
    }

    public static void printEachStatus(List<Cars> statuses) {
        statuses.forEach(status -> drawCarPaths(status.getValue()));
    }

    public static void printWinners(List<Car> cars) {
        System.out.println(getWinnerNames(cars) + "가 최종 우승했습니다.");
    }

    private static String getWinnerNames(List<Car> winners) {
        List<String> names = winners.stream().map(Car::getName).toList();
        return String.join(",", names);
    }


    private static void drawCarPaths(List<Car> cars) {
        for (Car car: cars) {
            drawCarPath(car);
        }
        System.out.println();
    }

    private static void drawCarPath(Car car) {
        System.out.print(car.getName() + "|");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.print("⛟");
        System.out.println();
    }

}
