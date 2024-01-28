package step1.racingcar.view;

import step1.racingcar.vo.Cars;

public class ResultView {

    public static void printReadyToStart(Cars cars) {
        System.out.println("실행 결과");
        printPositions(cars);
        System.out.println();
    }

    public static void printPositions(Cars cars) {
        cars.getPositions().forEach(position -> System.out.println("-".repeat(position)));
    }
}
