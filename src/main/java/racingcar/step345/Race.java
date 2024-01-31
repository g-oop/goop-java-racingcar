package racingcar.step345;

public class Race {

    private final Lap[] laps;

    public Race(int numberOfCars, int numberOfLaps) {

        laps = new Lap[numberOfLaps];
        laps[0] = new Lap(numberOfCars);
    }

    public int begin(Rule rule) {

        int totalStopCount = laps.length * laps[0].getTotalCars();
        for (int l = 0; l < laps.length; l++) {
            if (l > 0) laps[l] = laps[l - 1];
            totalStopCount -= laps[l].start(rule);
            ResultView.printResult(laps[l].getOdometerList());
        }
        return totalStopCount;
    }

    public int getLastLapDistance() {
        return laps[laps.length - 1].getTotalDistance();
    }
}
