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
        return Objects.hash(position);
    }
}
