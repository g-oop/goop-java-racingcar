package gameboy.gamepack.racinggame.data.entity;

import gameboy.gamepack.racinggame.data.vo.*;

public class Car {

    private Name name;
    private Position position;

    public Car() {
        this(new Name(), new Position());
    }

    public Car(String name) {
        this(new Name(name), new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void run() {
        position.add();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
