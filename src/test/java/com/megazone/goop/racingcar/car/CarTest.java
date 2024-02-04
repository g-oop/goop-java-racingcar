package com.megazone.goop.racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.megazone.goop.racingcar.car.Car;
import com.megazone.goop.racingcar.car.CarName;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new CarName("gv80"));
    }

    @DisplayName("자동차는 랜덤값이 4 이상인 경우에 1 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveByOneIfValueFourOrMoreTest(int randValue) {
        int moveDistance = 1;
        assertThat(car.move(randValue)).isEqualTo(moveDistance);
    }

    @DisplayName("자동차는 랜덤값이 4 미만인 경우에 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveIfValueFourOrMoreTest(int randValue) {
        assertThat(car.move(randValue)).isZero();
    }

    @DisplayName("자동차의 랜덤값이 4 이상인 경우, 전체 이동거리는 반복회수와 같다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void getTotalDistanceIfValueFourOrMoreTest(int randValue) {
        int totalRound = 5;

        for (int round = 0; round < totalRound; round++) {
            car.move(randValue);
        }

        assertThat(car.getPosition()).isEqualTo(totalRound);
    }

    @DisplayName("자동차의 랜덤값이 4 미만인 경우, 전체 이동거리는 0이다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getTotalDistanceIfFourUnderTest(int randValue) {
        int totalRound = 5;

        for (int round = 0; round < totalRound; round++) {
            car.move(randValue);
        }

        assertThat(car.getPosition()).isZero();
    }
}
