package step1.racingcar.domain.vo;

import step1.racingcar.exception.CarNameException;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        validateCarName(name);
        this.position = initializePosition();
        this.name = name;
    }

    public int initializePosition() {
        return 1;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new CarNameException("자동차 이름이 5자리 초과되었습니다.");
        }
    }

    public void move(int condition) {
        if (isMovable(condition)) {
            position++;
        }
    }

    private boolean isMovable(int condition) {
        return condition >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
