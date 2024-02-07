package step1.racingcar.domain.vo;

import java.util.List;

import step1.racingcar.strategy.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(getRandomNumber()));
    }

    private static int getRandomNumber() {
        return new RandomNumberGenerator().generateNumber();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinnerNames() {
        return cars.stream()
            .filter(this::isMaxPosition)
            .map(Car::getName)
            .toList();
    }

    private boolean isMaxPosition(Car car) {
        return car.getPosition() == getMaxPosition();
    }

    private int getMaxPosition() {
        int position = 0;
        for(Car car : cars) {
            position = Math.max(position, car.getPosition());
        }
        return position;
    }

}
