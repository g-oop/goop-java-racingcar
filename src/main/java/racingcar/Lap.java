package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Lap {

    private final List<Car> cars;

    public Lap(int numberOfCars) {

        cars = new ArrayList<>();
        for (int c = 0; c < numberOfCars; c++) {
            cars.add(new Car());
        }
    }

    public void start() {

        for (Car car : cars) {
            car.run();
        }
    }

    public void stop() {

    }

    public int getTotalDistance() {

        int totalDistance = 0;
        for (Car car : cars) {
            totalDistance += car.getOdometer();
        }
        return totalDistance;
    }
}
