package gameboy.gamepack.racinggame.domain.data.vo;

import java.util.*;

import gameboy.gamepack.racinggame.domain.data.entity.Car;

public class RaceLog {

    private List<Car> cars;

    public RaceLog(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
