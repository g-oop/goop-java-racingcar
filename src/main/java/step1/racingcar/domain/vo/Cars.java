package step1.racingcar.domain.vo;

import java.util.List;

import step1.racingcar.strategy.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void initializeCars() {
        cars.forEach(Car::initializePosition);
    }

    public void move() {
        cars.forEach(car -> car.move(new RandomNumberGenerator().generateNumber()));
    }

    public List<Integer> getPositions() {
        return cars.stream()
            .map(Car::getPosition)
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

}
