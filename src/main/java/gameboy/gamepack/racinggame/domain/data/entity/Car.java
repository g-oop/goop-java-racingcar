package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Name;
import gameboy.gamepack.racinggame.domain.data.vo.Position;

public class Car {

    private final Name name;
    private final Position position;
    private final CarMovement movement;

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
        this.movement = new CarMovement();
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }

    public Car run() {
        return new Car(name, movement.move(position));
    }

    public boolean isSamePosition(Position that) {
        return position.equals(that);
    }

}
