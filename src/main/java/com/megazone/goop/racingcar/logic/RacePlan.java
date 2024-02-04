package com.megazone.goop.racingcar.logic;

import java.util.List;

public record RacePlan(
    List<CarName> CarNames,
    int roundCount
) {
}
