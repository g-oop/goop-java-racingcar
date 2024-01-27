package step1.racingcar;

import java.util.List;
import java.util.stream.IntStream;

import step1.racingcar.vo.Car;
import step1.racingcar.vo.Cars;

public class CarManager {

    private final int carCount;
    private final int tryCount;
    private Cars cars;

    public CarManager(int carCount, int tryCount) {
        this.carCount = carCount;
        this.tryCount = tryCount;
    }

    public void readyToStart() {
        List<Car> carList = IntStream.range(0, carCount)
            .mapToObj(i -> new Car())
            .toList();
        cars = new Cars(carList);
    }

    public List<Integer> moveCars(int condition) {
        return cars.moveCars(condition);
    }

    public int getCarCount() {
        return carCount;
    }

    public int getTryCount() {
        return tryCount;
    }

}
