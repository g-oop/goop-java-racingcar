package racingcar.racing;

import racingcar.entry.Car;
import racingcar.entry.MovePolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingEntries {

    private final List<Car> cars;
    private final MovePolicy movePolicy;

    private final List<Car> winners = new ArrayList<>();
    private int maxPosition = 0;

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

    public List<Car> getWinners() {
        winners.clear();
        maxPosition = 0;
        for (Car car: this.cars) {
            maxPosition = addWinnerAndGetNewMaxPosition(car);
        }
        return winners;
    }

    private int addWinnerAndGetNewMaxPosition(Car car) {
        int currentPosition = car.currentPosition();
        if (currentPosition > maxPosition) {
            winners.clear();
            winners.add(car);
            return currentPosition;
        }
        if (currentPosition == maxPosition) {
            winners.add(car);
        }
        return maxPosition;
    }
}
