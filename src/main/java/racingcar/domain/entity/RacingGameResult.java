package racingcar.domain.entity;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.entity.car.Car;
import racingcar.domain.entity.car.Cars;

public class RacingGameResult {
    private final List<Cars> carsHistory = new ArrayList<>();

    public void logCurrentStatus(Cars cars){
        carsHistory.add(cars);
    }

    public List<Car> getWinners() {
        List<Car> cars = carsHistory.get(carsHistory.size() -1).getValue();
        int maxPosition = getMaxPosition(cars);
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    private int getMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car: cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }


    public List<Cars> getCarsHistory() {
        return carsHistory;
    }
}
