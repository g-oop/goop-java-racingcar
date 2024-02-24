package racingcar.domain;

import racingcar.domain.entity.RacingGameResult;
import racingcar.domain.entity.car.Cars;
import racingcar.domain.strategy.NumberGenerator;

public class RacingGame{

    public RacingGameResult race(String[] carNames, int attempts, NumberGenerator numberGenerator){
        RacingGameResult result = new RacingGameResult();
        Cars cars = new Cars(carNames);
        for (int i = 0; i < attempts; i++) {
            cars = cars.moveAll(numberGenerator);
            result.logCurrentStatus(cars);
        }
        return result;
    }

}
