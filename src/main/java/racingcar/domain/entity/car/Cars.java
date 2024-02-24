package racingcar.domain.entity.car;

import java.util.Arrays;
import java.util.List;

import racingcar.domain.strategy.NumberGenerator;

public class Cars {
    private final List<Car> value;

    public Cars(String[] carNames){
        this(Arrays.stream(carNames)
            .map(Car::new)
            .toList());
    }
    private Cars(List<Car> value) {
        this.value = value;
    }

    public void move(NumberGenerator numberGenerator) {
        for (Car car: value) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return value.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car: value) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getValue() {
        return value;
    }
}
