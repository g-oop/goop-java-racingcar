package racingcar;

import java.util.*;

public class Lap {

    private final List<Car> cars;

    public Lap(int numberOfCars) {

        cars = new ArrayList<>();
        for (int c = 0; c < numberOfCars; c++) {
            cars.add(new Car());
        }
    }

    public void start(Rule rule) {

        for (Car car : cars) {
            if (!rule.isStop()) {
                car.run();
            }
        }
    }

    public void stop() {

    }

    public int getTotalDistance() {
        return Arrays.stream(getOdometerList()).sum();
    }

    public int[] getOdometerList() {
        return cars.stream().mapToInt(Car::getOdometer).toArray();
    }

    public int getTotalCars() {
        return cars.size();
    }
}
