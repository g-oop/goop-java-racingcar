package step1.racingcar.vo;

import java.util.List;

import step1.racingcar.RandomUtils;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void initializeCars() {
        cars.forEach(Car::initializePosition);
    }

    public List<Integer> moveCars() {
        return cars.stream()
            .peek(car -> car.move(RandomUtils.getRandom()))
            .map(Car::getPosition)
            .toList();
    }

    public List<Integer> getPositions() {
        return cars.stream()
            .map(Car::getPosition)
            .toList();
    }

    public int getCarsCount() {
        return cars.size();
    }
}
