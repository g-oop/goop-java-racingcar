package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.*;
import racingcar.view.RacingGameView;

public class RacingGameInitializer implements GameInitializer{
    private final RacingGameView view;

    public RacingGameInitializer(RacingGameView view) {
        this.view = view;
    }

    public RacingGame init(){
        List<Car> cars = createCars(view.getCarCount());
        int attemptCount = view.getAttemptCount();

        return new RacingGame(new RacingGameSetting(cars, attemptCount), view);
    }


    private List<Car> createCars(int carCount){
        List<Car> cars = new ArrayList<>();
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < carCount; i++) {
            cars.add(new DefaultCar(numberGenerator, String.valueOf(i+1)));
        }

        return cars;
    }
}
