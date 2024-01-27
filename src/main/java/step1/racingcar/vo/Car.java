package step1.racingcar.vo;

public class Car {

    private int loc;

    public Car() {
        loc = 1;
    }

    public void moveIfMovable(int condition) {
        if (isMovable(condition)) {
            loc++;
        }
    }

    private boolean isMovable(int condition) {
        return condition >= 4;
    }

    public int getLoc() {
        return loc;
    }
}
