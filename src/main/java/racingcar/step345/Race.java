package racingcar.step345;

public class Race {

    private final Lap[] laps;

    public Race(int numberOfCars, int numberOfLaps) {

        laps = new Lap[numberOfLaps];
        laps[0] = new Lap(numberOfCars);
    }

    public void begin(Rule rule) {

        for (int l = 0; l < laps.length; l++) {
            if (l > 0) laps[l] = laps[l - 1];
            laps[l].start(rule);
            ResultView.printResult(laps[l].getOdometerList());
        }
    }

    public int getLastLapDistance() {
        return laps[laps.length - 1].getTotalDistance();
    }
}
