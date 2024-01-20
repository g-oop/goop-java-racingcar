package racingcar.application;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.car.Car;
import racingcar.domain.car.DefaultCar;
import racingcar.view.InputView;

public class RacingGame implements Game{
    private static final String INIT_CARS_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String INIT_ATTEMPTS_MESSAGE = "시도할 회수는 몇 회 인가요?";

    private final InputView inputView;

    public RacingGame(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public void play() {
        List<Car> cars = createCars(inputView.getNumberInput(INIT_CARS_MESSAGE));
        int attempts = inputView.getNumberInput(INIT_ATTEMPTS_MESSAGE);
        race(cars, attempts);
    }

    public List<Car> createCars(int carCount){
        List<Car> cars = new ArrayList<>();
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();

        for (int i = 0; i < carCount; i++) {
            cars.add(new DefaultCar(numberGenerator, String.valueOf(i+1)));
        }

        return cars;
    }

    public void race(List<Car> cars, int attempts){
        for (int i = 0; i < attempts; i++) {
            for (Car car:cars) {
                car.move();
            }
        }
    }

}
