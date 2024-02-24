package racingcar.domain.entity.car;

import java.util.*;

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

    public Cars moveAll(NumberGenerator numberGenerator) {
        List<Car> currentCars = new ArrayList<>();
        for (Car car: value) {
            currentCars.add(car.move(numberGenerator.generate()));
        }
        return new Cars(currentCars);
    }

    public List<Car> getValue() {
        return value;
    }
}
