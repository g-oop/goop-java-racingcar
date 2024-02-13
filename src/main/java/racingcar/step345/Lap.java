package racingcar.step345;

import java.util.*;

public class Lap {

    private final List<Car> cars;

    public Lap(int numberOfCars) {

        this.cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            this.cars.add(new Car());
        }
    }

    public void start(Rule rule) {

        for (Car car : this.cars) {
            if (rule.isRun()) car.run();
        }
    }

    public void pause() {

        for (Car car : this.cars) {
            car.stop();
        }
    }

    public int getTotalDistance() {
        return Arrays.stream(getOdometerList())
            .sum();
    }

    public int[] getOdometerList() {
        return this.cars.stream()
            .mapToInt(Car::getOdometer)
            .toArray();
    }
}
