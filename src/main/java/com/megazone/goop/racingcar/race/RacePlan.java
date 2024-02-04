package com.megazone.goop.racingcar.race;

import java.util.List;

import com.megazone.goop.racingcar.car.CarName;

public record RacePlan(
    List<CarName> CarNames,
    int roundCount
) {
}
