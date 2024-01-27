package step1.racingcar.vo;

import java.util.Objects;

import step1.racingcar.util.NumberGenerator;

public class Car {

    private int position;

    public Car() {
        this.position = initializePosition();
    }

    public int initializePosition() {
        return 1;
    }

    public void move(NumberGenerator numberGenerator) {
        if (isMovable(numberGenerator.generateNumber())) {
            position++;
        }
    }

    private boolean isMovable(int condition) {
        return condition >= 4;
    }

    public int getPosition() {
        return position;
    }

}
