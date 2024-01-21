package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

class RacingCarTest {

    @DisplayName("주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.")
    @ValueSource(ints = {1, 2, 3})
    @ParameterizedTest
    void move(int cars) {

        ByteArrayInputStream in = new ByteArrayInputStream(String.valueOf(cars).getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int n = inputView.inputCars();

        RacingCar racingCar = new RacingCar(n);

        racingCar.go();
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n);

        racingCar.stop();
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n);

        racingCar.go();
        Assertions.assertThat(racingCar.getResult()).isEqualTo(n * 2);
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

        RacingCar racingCar = new RacingCar(n);

        racingCar.start(t, 7);
        Assertions.assertThat(racingCar.getResult()).isEqualTo(result);
    }

    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    @CsvSource(value = {"1|2|2", "2|1|2", "5|4|20"}, delimiter = '|')
    @ParameterizedTest
    void random(int cars, int tries, int result) {

        String data = String.join("\n", List.of(String.valueOf(cars), String.valueOf(tries), String.valueOf(result)));
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        int n = inputView.inputCars();
        int t = inputView.inputTries();

        RacingCar racingCar = new RacingCar(n);

        int stopCount = racingCar.start(t);
        Assertions.assertThat(racingCar.getResult()).isEqualTo(result - stopCount);
    }
}