package racingcar.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.entry.*;
import racingcar.mock.AlwaysMovePolicy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class RacingEntriesTest {

    @Test
    @DisplayName("지정한 수만큼 경주 참가자가 생성된다.")
    void create() {
        List<String> carNames = List.of("yamsr", "gilbe", "nooos");
        MovePolicy movePolicy = new RandomMovePolicy();
        RacingEntries racingEntries = RacingEntries.of(carNames, movePolicy);
        int result = racingEntries.getEntryCount();
        assertThat(result).isEqualTo(carNames.size());
    }

    @Test
    @DisplayName("자동차 이름은 중복될 수 없다.")
    void create_duplicateCarName() {
        List<String> carNames = List.of("yamsr", "gilbe", "nooos", "yamsr");
        MovePolicy movePolicy = new RandomMovePolicy();
        ThrowingCallable callable = () -> RacingEntries.of(carNames, movePolicy);
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "ab, ab",
        "ab,ab ",
        "ab, ab ",
        "ab , ab",
    })
    @DisplayName("자동차 이름은 공백을 제거하여 생성하고, 중복될 수 없다.")
    void create_duplicateCarName(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        MovePolicy movePolicy = new RandomMovePolicy();
        ThrowingCallable callable = () -> RacingEntries.of(carNames, movePolicy);
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("각 경주 참가자가 이동 횟수만큼 이동한다.")
    void move() {
        List<String> carNames = List.of("yamsr", "gilbe", "nooos");

        MovePolicy movePolicy = new AlwaysMovePolicy();
        RacingEntries racingEntries = RacingEntries.of(carNames, movePolicy);
        RacingEntries newEntries = racingEntries.move();

        for (Car car: newEntries.getEntries()) {
            assertThat(car.currentPosition()).isEqualTo(1);
        }
    }
}
