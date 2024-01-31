package gameboy.gamepack.racinggame.domain.data.entity;

import gameboy.gamepack.racinggame.domain.data.vo.Name;
import gameboy.gamepack.racinggame.domain.data.vo.Position;

public class AlwaysStopCar extends Car {

    public AlwaysStopCar(Name name) {
        super(name);
    }

    @Override
    public Car run() {
        return new Car(new Name("TEST"), new Position());
    }
}
