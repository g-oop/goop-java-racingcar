package racingcar.domain;

import racingcar.domain.entity.car.Car;

public record CarState(
    String name,
    int position
) {
    public static CarState of(Car car){
        return new CarState(car.getName(), car.getPosition());
    }
}
