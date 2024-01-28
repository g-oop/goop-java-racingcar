package step1.racingcar.domain.vo;

public class Car {

    private int position;

    public Car() {
        this.position = initializePosition();
    }

    public int initializePosition() {
        return 1;
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

}
