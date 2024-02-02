package com.megazone.goop.racingcar.logic;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.megazone.goop.racingcar.ui.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    List<Car> cars;

    @BeforeEach
    void setUp() {
        List<String> names = Arrays.asList("lay", "qm5", "k9", "sonata");

        cars = names.stream()
            .map(n -> new Car(n)).toList();
    }

    @DisplayName("입력한 수만큼 라운드를 반복한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void repeatRoundTest(int rounds) {
        Race race = new Race(cars, new ResultView(), new RandomGenerator());
        race.startRace(rounds);

        assertThat(race.getCurrentRound()).isEqualTo(rounds);
    }
}
