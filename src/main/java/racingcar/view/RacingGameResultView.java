package racingcar.view;

import java.util.List;

import racingcar.domain.car.Car;

public class RacingGameResultView {

    public static void printCurrentStatus(List<Car> cars) {
        drawCarPaths(cars);
    }

    private static   void drawCarPaths(List<Car> cars) {
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
