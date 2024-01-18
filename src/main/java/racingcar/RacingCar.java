package racingcar;

import java.util.Arrays;

public class RacingCar {

    private int[] cars;

    public RacingCar(int cars) {
        this.cars = new int[cars];
    }

    public void run(int tries) {
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] += tries;
        }
    }

    public void stop() {

    }

    public int getResult() {
        return Arrays.stream(this.cars).sum();
    }
}
