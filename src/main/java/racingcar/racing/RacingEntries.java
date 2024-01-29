package racingcar.racing;

import racingcar.entry.Car;
import racingcar.entry.MovePolicy;

import java.util.ArrayList;
import java.util.List;

public class RacingEntries {

    private final List<Car> cars;
    private final MovePolicy movePolicy;

    private RacingEntries(List<Car> cars, MovePolicy movePolicy) {
        validateCarNames(cars);

        this.cars = cars;
        this.movePolicy = movePolicy;
    }

    private void validateCarNames(List<Car> cars) {
        long count = cars.stream().map(Car::getName).distinct().count();
        if (cars.size() != count) {
            throw new IllegalArgumentException("자동차 이름이 중복되었습니다.");
        }
    }

    public static RacingEntries of(List<String> carNames, MovePolicy movePolicy) {
        return new RacingEntries(carNames.stream()
            .map(String::trim)
            .map(Car::new)
            .toList(), movePolicy);
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
        RacingWinners racingWinners = new RacingWinners(this);
        return racingWinners.getWinners();
    }
}
