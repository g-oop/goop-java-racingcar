package step1.racingcar.view;

import java.util.List;

import step1.racingcar.domain.vo.Cars;

public class ResultView {

    public static void printReadyToStart(Cars cars) {
        System.out.println("실행 결과");
        printPositions(cars);
        System.out.println();
    }

    public static void printPositions(Cars cars) {
        cars.getCars()
            .forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getPosition())));
    }

    public static void printWinnerNames(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    private static String addMiddleComma(int index, int size) {
        if (index != (size - 1)) {
             return ", ";
        }
        return "";
    }
}
