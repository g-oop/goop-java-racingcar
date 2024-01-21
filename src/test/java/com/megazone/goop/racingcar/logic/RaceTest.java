package com.megazone.goop.racingcar.logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.megazone.goop.racingcar.ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @DisplayName("입력한 수만큼 라운드를 반복한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void repeatRoundTest(int rounds) {
        Race race = new Race(new ResultView(), new RandomGenerator(), 3);
        race.startRace(rounds);

        assertThat(race.getCurrentRound()).isEqualTo(rounds);
    }
}
