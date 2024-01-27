package domain;

import java.util.Random;

public class Car {

    private static final int MIN_VALUE = 4;


    private int position;

    public Car() {
        this.position = 0;
    }


    public int getPosition() {
        return position;
    }

    public void move(int rangeNumber) {
        if (generateRandom(rangeNumber) >= MIN_VALUE) {
            position++;
        }
    }

    private int generateRandom(int rangeNumber) {
        return new Random().nextInt(rangeNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Car car = (Car) o;

        return position == car.position;
    }

    @Override
    public int hashCode() {
        return position;
    }


    public String getState() {
        StringBuilder state = new StringBuilder("|");
        state.append("-".repeat(Math.max(0, position)));
        state.append(">");
        return state.toString();
    }
}
