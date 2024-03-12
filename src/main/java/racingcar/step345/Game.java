package racingcar.step345;

public class Game {

    private final int numberOfCars;
    private final int numberOfLaps;

    public Game(int numberOfCars, int numberOfLaps) {

        this.numberOfCars = numberOfCars;
        this.numberOfLaps = numberOfLaps;
    }

    public int[][] begin(Rule rule) {

        Lap lap = new Lap(this.numberOfCars);

        int[][] laps = new int[this.numberOfLaps][this.numberOfCars];
        for (int i = 0; i < this.numberOfLaps; i++) {
            lap.start(rule);
            laps[i] = lap.getOdometerArray();
        }

        return laps;
    }
}
