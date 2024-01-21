package racingcar.domain.game;

import java.util.List;

import racingcar.domain.car.Car;

public record RacingGameSetting(
    List<Car> cars,
    int attemptCount
) {
}
