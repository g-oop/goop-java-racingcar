package com.megazone.goop.racingcar;

import com.megazone.goop.racingcar.logic.Race;
import com.megazone.goop.racingcar.logic.RandomGenerator;
import com.megazone.goop.racingcar.ui.InputView;

public class StartRacing {

    public static void main(String[] args) {
        InputView iv = new InputView();
        iv.setRules();

        Race race = new Race(new RandomGenerator(), iv.getCarCount());
        race.startRace(iv.getRoundCount());
    }
}
