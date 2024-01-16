package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RacingCarTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @Test
    void move() {

        int n = 5;

        RacingCar racingCar = new RacingCar(n);

        racingCar.run();
        int[] firstTry = racingCar.getResult();
        Assertions.assertThat(Arrays.stream(firstTry).sum()).isEqualTo(n);

        racingCar.stop();
        int[] secondTry = racingCar.getResult();
        Assertions.assertThat(Arrays.stream(secondTry).sum()).isEqualTo(n);

        racingCar.run();
        int[] thirdTry = racingCar.getResult();
        Assertions.assertThat(Arrays.stream(thirdTry).sum()).isEqualTo(n * 2);
    }
}