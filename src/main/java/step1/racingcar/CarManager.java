package step1.racingcar;

import java.util.List;
import java.util.stream.*;

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

    public List<List<Integer>> moveCars(int tryCount) {
        return Stream.generate(cars::moveCars).limit(tryCount).toList();
    }

    public List<Integer> getPositions() {
        return cars.getPositions();
    }

}
