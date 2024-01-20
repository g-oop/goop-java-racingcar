package racingcar.racing;

import racingcar.entry.Car;
import racingcar.entry.MovePolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingEntries {

    private final List<Car> cars = new ArrayList<>();

    public RacingEntries(int entryCount) {
        for (int i = 0; i < entryCount; i++) {
            cars.add(new Car());
        }
    }

    public RacingEntries(int entryCount, MovePolicy movePolicy) {
        for (int i = 0; i < entryCount; i++) {
            cars.add(new Car(movePolicy));
        }
    }

    public RacingEntries(RacingEntries racingEntries) {
        this.cars.addAll(racingEntries.getEntries());
    }

    public void move() {
        for (Car car: cars) {
            car.move();
        }
    }

    public int getEntryCount() {
        return cars.size();
    }

    public List<Car> getEntries() {
        ArrayList<Car> copyCars = new ArrayList<>();
        for (Car car: cars) {
            copyCars.add(new Car(car));
        }
        return copyCars;
    }
}
