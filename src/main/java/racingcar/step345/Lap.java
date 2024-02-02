package racingcar.step345;

import java.util.*;

public class Lap {

    private final List<Car> cars;

    public Lap(int numberOfCars) {

        cars = new ArrayList<>();
        for (int carIndex = 0; carIndex < numberOfCars; carIndex++) {
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
