package step1.racingcar;

import java.util.List;
import java.util.stream.*;

import step1.racingcar.view.ResultView;
import step1.racingcar.vo.Car;
import step1.racingcar.vo.Cars;

public class CarManager {

    private final Cars cars;

    public CarManager(int carCount) {
        List<Car> carList = Stream.generate(Car::new).limit(carCount).toList();
        cars = new Cars(carList);
    }

    public void readyToStart() {
        cars.initializeCars();
    }

    public void startGame(int tryCount) {
        ResultView.printReadyToStart(cars);
        moveCars(tryCount);
    }

    private void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            ResultView.printPositions(cars);
            System.out.println();
        }
    }
}
