package step1.racingcar.domain.vo;

import java.util.ArrayList;
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

    public List<String> getWinnerNames() {
        int maxPosition = getMaxPosition();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : cars) {
            addWinnerName(car, maxPosition, winnerNames);
        }
        return winnerNames;
    }

    private int getMaxPosition() {
        int position = 0;
        for(Car car : cars) {
            position = Math.max(position, car.getPosition());
        }
        return position;
    }

    private static void addWinnerName(Car car, int maxPosition, List<String> winnerNames) {
        if (car.getPosition() == maxPosition) {
            winnerNames.add(car.getName());
        }
    }

}
