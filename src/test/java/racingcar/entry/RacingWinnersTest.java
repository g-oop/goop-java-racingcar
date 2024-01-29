package racingcar.entry;

import org.junit.jupiter.api.*;
import racingcar.racing.RacingEntries;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingWinnersTest {


    @Test
    @DisplayName("경주 시작 전에는 모든 참가자가 우승자이다.")
    void winners_beforeRace() {
        List<String> carNames = List.of("yamsr", "gilbe", "nooos");

        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = RacingEntries.of(carNames, movePolicy);
        List<Car> winners = racingEntries.getWinners();

        assertThat(winners).hasSize(carNames.size());
    }

    @RepeatedTest(10)
    @DisplayName("경주 시작 후에는 우승자 수는 참가자 수보다 같거다 적다.")
    void winners_afterRace() {
        List<String> carNames = List.of("yamsr", "gilbe", "nooos");

        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = RacingEntries.of(carNames, movePolicy);
        RacingEntries newEntries = racingEntries.move();
        List<Car> winners = newEntries.getWinners();

        assertThat(winners).hasSizeLessThanOrEqualTo(carNames.size());
    }
}
