package racingcar.entry;

public class Car {

    private final CarPosition position;
    private MovePolicy movePolicy;

    public Car() {
        this.position = new CarPosition();
    }

    public Car(MovePolicy movePolicy) {
        this.position = new CarPosition();
        this.movePolicy = movePolicy;
    }

    public Car(Car car) {
        this.movePolicy = car.movePolicy;
        this.position = new CarPosition(car.position.current());
    }

    public void setMovePolicy(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void move() {
        if (canMove()) {
            position.increase();
        }
    }

    public int currentPosition() {
        return position.current();
    }

    private boolean canMove() {
        if (this.movePolicy == null) {
            return false;
        }
        return movePolicy.canMove();
    }
}
