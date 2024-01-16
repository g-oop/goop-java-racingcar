package racingcar;

public class RacingCar {

    private int[] cars;

    public RacingCar(int cars) {
        this.cars = new int[cars];
    }

    public void run() {
        for (int i = 0; i < this.cars.length; i++) {
            this.cars[i] += 1;
        }
    }

    public void stop() {

    }

    public int[] getResult() {
        return this.cars;
    }
}
