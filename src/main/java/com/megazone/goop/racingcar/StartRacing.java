package com.megazone.goop.racingcar;

import java.util.List;

import com.megazone.goop.racingcar.logic.*;
import com.megazone.goop.racingcar.ui.InputView;
import com.megazone.goop.racingcar.ui.ResultView;

public class StartRacing {

    public static void main(String[] args) {
        InputView iv = new InputView();
        iv.setRules();

        List<Car> cars = iv.getCarNames().stream()
            .map(n -> new Car(n)).toList();

        Race race = new Race(cars, new ResultView(), new RandomGenerator());
        race.startRace(iv.getRoundCount());
        race.endRace();
    }
}
