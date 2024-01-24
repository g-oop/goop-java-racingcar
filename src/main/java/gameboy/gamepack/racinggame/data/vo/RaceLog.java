package gameboy.gamepack.racinggame.data.vo;

import java.util.*;

import gameboy.gamepack.racinggame.data.entity.Car;

public class RaceLog {

    private List<Car> cars;

    public RaceLog(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
