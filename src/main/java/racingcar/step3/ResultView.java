package racingcar.step3;

import java.util.List;

class ResultView {
    public static void displayRace(List<Car> cars) {
        cars.forEach(car ->
                System.out.println("-".repeat(car.getPosition() + 1))
        );
        System.out.println("\n");
    }
}
