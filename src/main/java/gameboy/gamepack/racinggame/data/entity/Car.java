package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.data.vo.*;

public class Car {

    private CarStatus status;

    public Car() {
        this(new Name(), new Position());
    }

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name, Position position) {
        this.status = new CarStatus(name, position);
    }

    public void run() {
        status.positionAdd();
    }

    public int getPosition() {
        return status.getPosition();
    }

    public String getName() {
        return status.getName();
    }

    public CarStatus getStatus() {
        return status;
    }
}
