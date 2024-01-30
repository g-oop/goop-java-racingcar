package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

class RaceTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void move(int cars) {

        ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(cars).getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int n = inputView.inputCars();

        Lap lap = new Lap(n);
        Rule rule = new LinearRule();

        lap.start(rule);
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(n);

        lap.stop();
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(n);

        lap.start(rule);
        Assertions.assertThat(lap.getTotalDistance()).isEqualTo(n * 2);
    }

    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.")
    @CsvSource(value = {"5|3|15", "3|5|15", "2|1|2"}, delimiter = '|')
    @ParameterizedTest
    void input(int cars, int tries, int result) {

        String data = String.join("\n", List.of(String.valueOf(cars), String.valueOf(tries), String.valueOf(result)));
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int n = inputView.inputCars();
        int t = inputView.inputTries();

        Race race = new Race(n, t);
        Rule rule = new LinearRule();

        race.begin(rule);
        Assertions.assertThat(race.getLastLapDistance()).isEqualTo(result);
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @CsvSource(value = {"1|2|1", "2|1|1", "5|4|10"}, delimiter = '|')
    @ParameterizedTest
    void random(int cars, int tries, int result) {

        String data = String.join("\n", List.of(String.valueOf(cars), String.valueOf(tries), String.valueOf(result)));
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int n = inputView.inputCars();
        int t = inputView.inputTries();

        Race race = new Race(n, t);
        Rule rule = new RandomRule(777);

        race.begin(rule);
        Assertions.assertThat(race.getLastLapDistance()).isEqualTo(result);
    }
}