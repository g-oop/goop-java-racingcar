package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.entry.*;
import racingcar.mock.AlwaysMovePolicy;

import static org.assertj.core.api.Assertions.assertThat;

class RacingEntriesTest {

    @Test
    @DisplayName("지정한 수만큼 경주 참가자가 생성된다.")
    void create() {
        int entryCount = 5;
        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = new RacingEntries(entryCount, movePolicy);
        int result = racingEntries.getEntryCount();
        assertThat(result).isEqualTo(entryCount);
    }

    @Test
    @DisplayName("각 경주 참가자가 이동 횟수만큼 이동한다.")
    void move() {
        int entryCount = 5;

        MovePolicy movePolicy = new AlwaysMovePolicy();
        RacingEntries racingEntries = new RacingEntries(entryCount, movePolicy);
        RacingEntries newEntries = racingEntries.move();

        for (Car car: newEntries.getEntries()) {
            assertThat(car.currentPosition()).isEqualTo(1);
        }
    }
}
