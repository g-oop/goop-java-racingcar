package racingcar.racing;

import racingcar.entry.Car;

import java.util.*;

public class RacingEntries {

    private final List<Car> cars = new ArrayList<>();

    public RacingEntries(int entryCount, Random random) {
        for (int i = 0; i < entryCount; i++) {
            cars.add(new Car(random));
        }
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
        return Collections.unmodifiableList(cars);
    }
}
