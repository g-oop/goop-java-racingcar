package step1.racingcar.domain.vo;

public class Car {

    private final CarPosition position;
    private final CarName name;

    public Car(String name) {
        this.position = new CarPosition();
        this.name = new CarName(name);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.name();
    }

    public void move(int condition) {
        if (isMovable(condition)) {
            this.position.addPosition();
        }
    }

    private boolean isMovable(int condition) {
        return condition >= 4;
    }
}
