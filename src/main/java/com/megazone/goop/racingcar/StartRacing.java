package com.megazone.goop.racingcar;

import com.megazone.goop.racingcar.race.Race;
import com.megazone.goop.racingcar.race.RacePlan;
import com.megazone.goop.racingcar.ui.InputView;
import com.megazone.goop.racingcar.ui.ResultView;
import com.megazone.goop.racingcar.util.RandomGenerator;

public class StartRacing {

    public static void main(String[] args) {
        InputView iv = new InputView();
        RacePlan racePlan = iv.setRacePlan();

        Race race = new Race(racePlan, new RandomGenerator());
        race.startRace();

        ResultView rv = new ResultView();
        rv.displayRecords(race.getRoundRecords());
        rv.displayWinners(race.getWinners());
    }
}
