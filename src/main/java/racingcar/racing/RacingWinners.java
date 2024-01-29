package racingcar.racing;

import racingcar.entry.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingWinners {

    private final RacingEntries entries;
    private List<Car> winners;
    private int maxPosition = 0;

    public RacingWinners(RacingEntries entries) {
        this.entries = entries;
    }

    public List<Car> getWinners() {
        if (winners != null) {
            return winners;
        }

        winners = new ArrayList<>();
        maxPosition = 0;
        for (Car car: this.entries.getEntries()) {
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
