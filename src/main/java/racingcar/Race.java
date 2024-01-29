package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

//    private Rule rule;

    private final List<Lap> laps;


    public Race(int numberOfCars, int numberOfLaps) {

        laps = new ArrayList<>();
        for (int l = 0; l < numberOfLaps; l++) {
            laps.add(new Lap(numberOfCars));
        }
    }

    public void start() {
        for (Lap lap : laps) {
            lap.start();
        }
    }

    public int getCumulativeDistanceOfAllCars() {

        int cumulativeDistance = 0;
        for (Lap lap : laps) {
            cumulativeDistance += lap.getTotalDistance();
        }
        return cumulativeDistance;
    }
}
