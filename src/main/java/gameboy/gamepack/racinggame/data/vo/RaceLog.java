package gameboy.gamepack.racinggame.data.vo;

import java.util.*;

import gameboy.gamepack.racinggame.data.entity.Car;

public class RaceLog {

    private List<Car> cars;

    public RaceLog(List<Car> cars) {
        this.cars = createCarsLog(cars);
    }

    private List<Car> createCarsLog(List<Car> cars) {
        return cars
            .stream()
            .map(Car::copy)
            .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
