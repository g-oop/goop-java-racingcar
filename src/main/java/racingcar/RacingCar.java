package racingcar;

import java.util.Arrays;
import java.util.Random;

public class RacingCar {

    private int[] cars;

    public RacingCar(int cars) {
        this.cars = new int[cars];
    }

    public void stop() {

        for (int i = 0; i < this.cars.length; i++) {
            stop(i);
        }
    }

    public void go() {

        for (int i = 0; i < this.cars.length; i++) {
            go(i);
        }
    }

    public void start(int tries, int seed) {

        for (int i = 0; i < tries; i++) {
            run(seed);
            ResultView.printResult(this.cars);
        }
    }

    public void run(int seed) {

        for (int i = 0; i < this.cars.length; i++) {
            if (isStop(seed)) {
                stop(i);
            } else {
                go(i);
            }
        }
    }

    private boolean isStop(int seed) {

        Random random = new Random(seed);
        return random.nextInt(10) < 4;
    }

    public int start(int tries) {

        int stopCount = 0;
        for (int i = 0; i < tries; i++) {
            stopCount += run();
            ResultView.printResult(this.cars);
        }
        return stopCount;
    }

    public int run() {

        int stopCount = 0;
        for (int i = 0; i < this.cars.length; i++) {
            if (isStop()) {
                stop(i);
                stopCount += 1;
            } else {
                go(i);
            }
        }
        return stopCount;
    }

    private boolean isStop() {

        Random random = new Random();
        return random.nextInt(10) < 4;
    }

    public void stop(int c) {
        this.cars[c] += 0;
    }

    public void go(int c) {
        this.cars[c] += 1;
    }

    public int getResult() {
        return Arrays.stream(this.cars).sum();
    }
}
