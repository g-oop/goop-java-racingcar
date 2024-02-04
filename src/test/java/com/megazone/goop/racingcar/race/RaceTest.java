package com.megazone.goop.racingcar.race;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.megazone.goop.racingcar.car.CarName;
import com.megazone.goop.racingcar.race.Race;
import com.megazone.goop.racingcar.race.RacePlan;
import com.megazone.goop.racingcar.util.RandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @DisplayName("입력한 수만큼 라운드를 반복한다.")
    @ParameterizedTest
    @CsvSource(value = {"lay,qm5,k9,sm7:3", "lay,qm5,k9,sm7:5"}, delimiter = ':')
    void repeatRoundTest(String names, int round) {
        List<CarName> carNames = Arrays.stream(names.split(",", -1))
            .map(n -> new CarName(n.trim()))
            .toList();

        Race race = new Race(new RacePlan(carNames, round), new RandomGenerator());
        race.startRace();

        assertThat(race.getCurrentRound()).isEqualTo(round);
    }
}
