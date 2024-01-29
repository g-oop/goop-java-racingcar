package domain;

import domain.strategy.RandomMoveStrategy;

public class Car {

    private static final int MIN_VALUE = 4;
    private RandomMoveStrategy randomMoveStrategy;

    private int position;

    public Car() {
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

    public int generateRandomValueAndMove(int rangeNumber) {
        return randomMoveStrategy.generateRandomValue(rangeNumber);
    }
}
