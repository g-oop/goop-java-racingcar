package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.RacingGameInputView;
import racingcar.view.RacingGameResultView;

public class RacingGame{
    private final List<Car> cars;

    public RacingGame() {
        this.cars = createCars(RacingGameInputView.getCarNames());
    }

    public void start() {
        race(RacingGameInputView.getAttemptCount());
    }

    public void race(int attempts){
        for (int i = 0; i < attempts; i++) {
            moveCars();
            RacingGameResultView.printCurrentStatus(cars);
        }
        RacingGameResultView.printWinners(cars);
    }

    private void moveCars() {
        for (Car car: cars) {
            car.move(RandomNumberGenerator.generate());
        }
    }


    private List<Car> createCars(String[] carNames){
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

}
