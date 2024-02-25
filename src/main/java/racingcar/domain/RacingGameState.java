package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.entity.car.Car;
import racingcar.domain.entity.car.Cars;

public record RacingGameState (
    List<CarState> carStates
) {
    public static RacingGameState of(Cars cars){
        List<CarState> carStates = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carStates.add(CarState.of(car));
        }
        return new RacingGameState(carStates);
    }
}
