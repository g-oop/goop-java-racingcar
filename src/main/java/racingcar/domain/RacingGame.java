package racingcar.domain;

import java.util.List;

import racingcar.domain.entity.car.Car;
import racingcar.domain.entity.car.Cars;
import racingcar.domain.strategy.NumberGenerator;

public class RacingGame{
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(String[] carNames, NumberGenerator numberGenerator) {
        this(new Cars(carNames), numberGenerator);
    }


    private RacingGame(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public RacingGameResult race(int attempts){
        RacingGameResult result = new RacingGameResult();
        for (int i = 0; i < attempts; i++) {
            cars.moveAll(numberGenerator);
            result.logCurrentState(cars);
        }
        return result;
    }

    public List<Car> getWinners(){
        return cars.getWinners();
    }

}
