package racingcar.racing;

import org.junit.jupiter.api.*;
import racingcar.entry.*;
import racingcar.mock.AlwaysMovePolicy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingEntriesTest {

    @Test
    @DisplayName("지정한 수만큼 경주 참가자가 생성된다.")
    void create() {
        String[] carNames = new String[] {"ab", "nm", "xy"};
        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = new RacingEntries(carNames, movePolicy);
        int result = racingEntries.getEntryCount();
        assertThat(result).isEqualTo(carNames.length);
    }

    @Test
    @DisplayName("각 경주 참가자가 이동 횟수만큼 이동한다.")
    void move() {
        String[] carNames = new String[] {"ab", "nm", "xy"};

        MovePolicy movePolicy = new AlwaysMovePolicy();
        RacingEntries racingEntries = new RacingEntries(carNames, movePolicy);
        RacingEntries newEntries = racingEntries.move();

        for (Car car: newEntries.getEntries()) {
            assertThat(car.currentPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("경주 시작 전에는 모든 참가자가 우승자이다.")
    void winners_beforeRace() {
        String[] carNames = new String[] {"ab", "nm", "xy"};

        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = new RacingEntries(carNames, movePolicy);
        List<Car> winners = racingEntries.getWinners();

        assertThat(winners).hasSize(carNames.length);
    }

    @RepeatedTest(10)
    @DisplayName("경주 시작 후에는 우승자 수는 참가자 수보다 같거다 적다.")
    void winners_afterRace() {
        String[] carNames = new String[] {"ab", "nm", "xy"};

        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = new RacingEntries(carNames, movePolicy);
        RacingEntries newEntries = racingEntries.move();
        List<Car> winners = newEntries.getWinners();

        assertThat(winners).hasSizeLessThanOrEqualTo(carNames.length);
    }
}
