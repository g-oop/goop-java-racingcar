package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Name;
import gameboy.gamepack.racinggame.domain.data.vo.Position;

public class AlwaysRunCar extends Car {

    public AlwaysRunCar(Name name) {
        super(name);
    }

    @Override
    public Car run() {
        return new Car(new Name("TEST"), new Position(1));
    }
}
