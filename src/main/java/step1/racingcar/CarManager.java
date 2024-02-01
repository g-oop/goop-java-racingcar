package step1.racingcar;

import java.util.ArrayList;
import java.util.List;

import step1.racingcar.utils.StringSplitUtils;
import step1.racingcar.view.ResultView;
import step1.racingcar.domain.vo.Car;
import step1.racingcar.domain.vo.Cars;

public class CarManager {

    private final Cars cars;

    public CarManager(String carNames) {
        String[] carNameArr = StringSplitUtils.splitBySeparator("//,\n" + carNames);
        List<Car> carList = new ArrayList<>();
        for (String carName : carNameArr) {
            carList.add(new Car(carName));
        }
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
            cars.move();
            ResultView.printPositions(cars);
            System.out.println();
        }
    }
}
