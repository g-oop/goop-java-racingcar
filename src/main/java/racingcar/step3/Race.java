package racingcar.step3;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Race(int numberOfCars) {
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void start(int attempts) {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                if (i != 0) {
                    car.move();
                }
            }
            ResultView.displayRace(cars);
        }
    }
}
