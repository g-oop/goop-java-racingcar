package racingcar.domain;

import racingcar.domain.entity.car.Cars;
import racingcar.domain.strategy.NumberGenerator;

import static racingcar.view.RacingGameResultView.printCurrentStatus;
import static racingcar.view.RacingGameResultView.printWinners;

public class RacingGame{
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(String[] carNames, NumberGenerator numberGenerator){
        this(new Cars(carNames), numberGenerator);
    }

    private RacingGame(Cars cars, NumberGenerator numberGenerator){
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race(int attempts){
        for (int i = 0; i < attempts; i++) {
            cars.move(numberGenerator);
            printCurrentStatus(cars.getValue());
        }
        printWinners(cars.getWinners());
    }


}
