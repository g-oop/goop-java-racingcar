package racingcar.step345;

public class Race {

    private final Lap[] laps;

    public Race(int numberOfCars, int numberOfLaps) {

        laps = new Lap[numberOfLaps];
        laps[0] = new Lap(numberOfCars);
    }

    public void begin(Rule rule) {

        for (int lapIndex = 0; lapIndex < laps.length; lapIndex++) {
            if (lapIndex > 0) laps[lapIndex] = laps[lapIndex - 1];
            laps[lapIndex].start(rule);
            ResultView.printResult(laps[lapIndex].getOdometerList());
        }
    }

    public int getLastLapDistance() {
        return laps[laps.length - 1].getTotalDistance();
    }
}
