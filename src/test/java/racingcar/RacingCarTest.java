package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class RacingCarTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void move() {

        int n = 5;

        RacingCar racingCar = new RacingCar(n);

        racingCar.run(1);
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n);

        racingCar.stop();
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n);

        racingCar.run(1);
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n * 2);
    }

    @DisplayName("사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.")
    @CsvSource(value = {"5|3|15", "3|5|15", "2|1|2"}, delimiter = '|')
    @ParameterizedTest
    void input(int n, int t, int result) {

        RacingCar racingCar = new RacingCar(n);

        racingCar.run(t);
        Assertions.assertThat(racingCar.getResult()).isEqualTo(result);
    }
}