package racingcar.entry;

public class Car {

    private final CarName carName;
    private final CarPosition position;

    public Car(String name) {
        this.carName = new CarName(name);
        this.position = new CarPosition();
    }

    public Car(CarName carName, int position) {
        this.carName = carName;
        this.position = new CarPosition(position);
    }

    public Car move(MovePolicy movePolicy) {
        if (canMove(movePolicy)) {
            return new Car(carName, position.increase());
        }
        return this;
    }

    private boolean canMove(MovePolicy movePolicy) {
        return movePolicy.canMove();
    }

    public String getName() {
        return carName.value();
    }

    public int currentPosition() {
        return position.current();
    }
}
