package step1.racingcar.vo;

import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Integer> moveCars(int condition) {
        return cars.stream()
            .peek(car -> car.moveIfMovable(condition))
            .map(Car::getLoc)
            .toList();
    }
}
