package racingcar.step345;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LapTest {

    private final Rule rule = new LinearRule();

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void startAndStop(int numberOfCars) {

        Lap lap = new Lap(numberOfCars);

        lap.start(rule);
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(numberOfCars);

        lap.stop();
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(numberOfCars);

        lap.start(rule);
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(numberOfCars * 2);
    }
}
