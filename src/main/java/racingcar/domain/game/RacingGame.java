package racingcar.domain.game;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.car.Car;
import racingcar.domain.car.DefaultCar;
import racingcar.domain.numbergenerator.DefaultRandomNumberGenerator;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.RacingGameView;

public class RacingGame implements Game {

    private List<Car> cars;
    private int attempts;


    @Override
    public void start() {
        RacingGameView view = new RacingGameView(this);
        initialize(view);
        race(view);
    }

    private void race(RacingGameView view){
        for (int i = 0; i < attempts; i++) {
            moveCars();
            view.printCurrentStatus();
        }
    }


    private void moveCars() {
        for (Car car: cars) {
            car.move();
        }
    }


    private void initialize(RacingGameView view) {
        this.cars = createCars(view.getCarCount());
        this.attempts = view.getAttemptCount();
    }


    private List<Car> createCars(int carCount){
        List<Car> cars = new ArrayList<>();
        RandomNumberGenerator numberGenerator = new DefaultRandomNumberGenerator();

        for (int i = 0; i < carCount; i++) {
            cars.add(new DefaultCar(numberGenerator, String.valueOf(i+1)));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
