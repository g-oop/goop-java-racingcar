package gameboy.gamepack.racinggame.domain.data.vo;

import java.util.*;

import gameboy.gamepack.racinggame.domain.data.entity.Car;

public record RaceLog(
    List<Car> cars
) {
}
