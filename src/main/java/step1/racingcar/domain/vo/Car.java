package step1.racingcar.domain.vo;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        this.position = initializePosition();
        this.name = name;
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

    public String getName() {
        return name;
    }
}
