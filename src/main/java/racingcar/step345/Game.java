package racingcar.step345;

public class Game {

    private final int numberOfLaps;
    private final Lap lap;

    public Game() {

        InputView inputView = new InputView();

        this.numberOfLaps =  inputView.inputNumberOfLaps();
        this.lap = new Lap(inputView.inputNumberOfCars());
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
