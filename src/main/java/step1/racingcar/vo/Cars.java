package step1.racingcar.vo;

import java.util.List;

import step1.racingcar.RandomUtils;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> moveCars(int bound) {
        return cars.stream()
            .peek(car -> car.moveIfMovable(RandomUtils.getRandom(bound)))
            .map(Car::getLoc)
            .toList();
    }
}
