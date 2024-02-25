package racingcar.domain.entity.car;

import java.util.*;

import racingcar.domain.strategy.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] carNames){
        this(Arrays.stream(carNames)
            .map(Car::new)
            .toList());
    }

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car: cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
