package racingcar.racing;

import racingcar.entry.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<RacingEntries> racingEntriesHistory = new ArrayList<>();

    public void recordSnapshot(RacingEntries racingEntries) {
        racingEntriesHistory.add(racingEntries);
    }

    public List<Car> getWinners() {
        return racingEntriesHistory.get(racingEntriesHistory.size() - 1).getWinners();
    }

    public List<RacingEntries> getRacingEntriesHistory() {
        return racingEntriesHistory;
    }
}
