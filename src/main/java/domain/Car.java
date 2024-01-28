package domain;

import strategy.RandomMoveStrategy;
import strategy.RandomMoveStrategyImpl;

public class Car {

    private static final int MIN_VALUE = 4;
    private final RandomMoveStrategy randomMoveStrategy;

    private int position;

    public Car() {
        this.randomMoveStrategy = new RandomMoveStrategyImpl();
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
