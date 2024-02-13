package racingcar.step345;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    private final Rule rule = new LinearRule();

    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.")
    @CsvSource(value = {"5|3|15", "3|5|15", "2|1|2"}, delimiter = '|')
    @ParameterizedTest
    void begin(int numberOfCars, int numberOfLaps, int result) {

        Game game = new Game(numberOfCars, numberOfLaps);

        int[][] laps = game.begin(rule);

        Assertions.assertThat(Arrays.stream(laps[laps.length - 1]).sum()).isEqualTo(result);
    }
}