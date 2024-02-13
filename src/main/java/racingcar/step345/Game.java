package racingcar.step345;

public class Game {

    private final int numberOfCars;
    private final int numberOfLaps;
    private final Lap lap;

    public Game(int numberOfCars, int numberOfLaps) {


        this.numberOfCars = numberOfCars;
        this.numberOfLaps = numberOfLaps;
        this.lap = new Lap(this.numberOfCars);
    }

    public void begin(Rule rule) {

        for (int i = 0; i < numberOfLaps; i++) {
            lap.start(rule);
            ResultView.printResult(lap.getOdometerList());
        }
    }

    public int getLastLapDistance() {
        return lap.getTotalDistance();
    }
}
