package racingcar.step345;

import java.util.Arrays;

public class Game {

    private final int[][] laps;

    public Game(int numberOfCars, int numberOfLaps) {
        this.laps = new int[numberOfLaps][numberOfCars];
    }

    public void begin(Rule rule) {

        Lap lap = new Lap(this.laps[0].length);
        for (int i = 0; i < this.laps.length; i++) {
            lap.start(rule);
            this.laps[i] = lap.getOdometerList();
        }
    }

    public int[][] getLaps() {
        return this.laps;
    }

    public int getLastLapDistance() {
        return Arrays.stream(this.laps[this.laps.length - 1]).sum();
    }
}
