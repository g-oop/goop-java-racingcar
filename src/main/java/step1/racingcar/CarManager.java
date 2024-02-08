package step1.racingcar;

import java.util.ArrayList;
import java.util.List;

import step1.racingcar.view.ResultView;
import step1.racingcar.domain.vo.Car;
import step1.racingcar.domain.vo.Cars;

public class CarManager {

    private final Cars cars;

    public CarManager(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
    }

    public void startGame(int tryCount) {
        ResultView.printReadyToStart(cars);
        moveCars(tryCount);
        ResultView.printWinnerNames(cars.getWinnerNames());
    }

    private void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            cars.move();
            ResultView.printPositions(cars);
            System.out.println();
        }
    }

}
