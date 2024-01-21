package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.data.vo.Position;

public class Car {
    private Position position;

    public Car() {
        this.position = new Position();
    }

    public Car(Position position) {
        this.position = position;
    }

    public void run() {
        position.add();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
