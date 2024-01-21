package racingcar.entry;

public class Car {

    private final CarPosition position;

    public Car() {
        this.position = new CarPosition();
    }

    public Car(int position) {
        this.position = new CarPosition(position);
    }

    public Car move(MovePolicy movePolicy) {
        if (canMove(movePolicy)) {
            return new Car(position.increase());
        }
        return this;
    }

    public int currentPosition() {
        return position.current();
    }

    private boolean canMove(MovePolicy movePolicy) {
        return movePolicy.canMove();
    }
}
