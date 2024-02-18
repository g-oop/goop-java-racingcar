package racingcar.domain.game;

import java.util.*;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameResultView;

public class RacingGame{
    private final List<Car> cars;

    public RacingGame(String[] carNames){
        this(Arrays.stream(carNames)
            .map(Car::new)
            .toList());
    }

    private RacingGame(List<Car> cars){
        this.cars = cars;
    }

    public void start() {
        race(RacingGameInputView.getAttemptCount());
    }

    public void race(int attempts){
        for (int i = 0; i < attempts; i++) {
            moveCars();
            RacingGameResultView.printCurrentStatus(cars);
        }
        RacingGameResultView.printWinners(getWinners());
    }

    private void moveCars() {
        for (Car car: cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }


    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


}
