package domain;

import strategy.NumberGeneratorImpl;

public class Car {

    private static final int MIN_VALUE = 4;

    private int position;

    public Car() {
        this.numberGenerator = new NumberGeneratorImpl();
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= MIN_VALUE) {
            position++;
        }
    }


}
