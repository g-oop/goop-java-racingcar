package racingcar.step345;

public class Race {

    private final Lap[] laps;

    public Race(int numberOfCars, int numberOfLaps) {

        laps = new Lap[numberOfLaps];
        laps[0] = new Lap(numberOfCars);
    }

    public int begin(Rule rule) {

        int totalStopCount = laps.length * laps[0].getTotalCars();
        for (int lapIndex = 0; lapIndex < laps.length; lapIndex++) {
            if (lapIndex > 0) laps[lapIndex] = laps[lapIndex - 1];
            totalStopCount -= laps[lapIndex].start(rule);
            ResultView.printResult(laps[lapIndex].getOdometerList());
        }
        return totalStopCount;
    }

    public int getLastLapDistance() {
        return laps[laps.length - 1].getTotalDistance();
    }
}
