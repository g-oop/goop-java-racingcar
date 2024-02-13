package racingcar.step345;

public class Car {

    private int odometer;

    public Car() {
        this.odometer = 0;
    }

    public void run() {
        this.odometer += 1;
    }

    public void pause() {
    }

    public int getOdometer() {
        return this.odometer;
    }
}
