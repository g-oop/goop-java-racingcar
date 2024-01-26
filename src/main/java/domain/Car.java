package domain;

import java.util.Random;

public class Car {

    private static final int MIN_VALUE = 4;


    private int position;

    public Car() {
        this.position = 0;
        this.random = new Random();
    }


    public int getPosition() {
        return position;
    }

    public void move(int number) {
        if (number >= MIN_VALUE) {
            position++;
        }
    }


    public String getState() {
        StringBuilder state = new StringBuilder("|");
        state.append("-".repeat(Math.max(0, position)));
        state.append(">");
        return state.toString();
    }
}
