package racingcar.racing;

import racingcar.entry.Car;
import racingcar.entry.MovePolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingEntries {

    private final List<Car> cars;
    private final MovePolicy movePolicy;

    public RacingEntries(String[] carNames, MovePolicy movePolicy) {
        this.cars = new ArrayList<>();
        for (String carName: carNames) {
            this.cars.add(new Car(carName));
        }
        this.movePolicy = movePolicy;
    }

    public RacingEntries(List<Car> cars, MovePolicy movePolicy) {
        this.cars = cars;
        this.movePolicy = movePolicy;
    }

    public RacingEntries move() {
        List<Car> newCars = new ArrayList<>();
        for (Car car: cars) {
            newCars.add(car.move(movePolicy));
        }
        return new RacingEntries(newCars, movePolicy);
    }

    public int getEntryCount() {
        return cars.size();
    }

    public List<Car> getEntries() {
        return cars;
    }
}
