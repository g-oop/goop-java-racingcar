package racingcar.racing;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {

    private final List<RacingEntries> racingEntriesList = new ArrayList<>();

    public void recordSnapshot(RacingEntries racingEntries) {
        racingEntriesList.add(racingEntries);
    }

    public List<RacingEntries> getRacingEntriesList() {
        return racingEntriesList;
    }
}
