package racingcar.view;

import java.util.List;

import racingcar.domain.car.Car;

public class RacingGameResultView {

    public static void printCurrentStatus(List<Car> cars) {
        drawCarPaths(cars);
    }

    public static void printWinners(List<Car> cars) {
        String winnerNames = stringifyList(getWinnerNames(cars));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    private static String stringifyList(List<String> list) {
        String enclosedText = list.toString();
        return enclosedText.substring(1, enclosedText.length() - 1);
    }

    private static List<String> getWinnerNames(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();
    }

    private static int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
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
