package racingcar.step345;

public class Race {

    private final int numberOfLaps;
    private final Lap laps;

    public Race(int numberOfCars, int numberOfLaps) {

        this.numberOfLaps = numberOfLaps;
        laps = new Lap(numberOfCars);
    }

    public void begin(Rule rule) {

        for (int lapIndex = 0; lapIndex < numberOfLaps; lapIndex++) {
            laps.start(rule);
            ResultView.printResult(laps.getOdometerList());
        }
    }

    public int getLastLapDistance() {
        return laps.getTotalDistance();
    }
}
