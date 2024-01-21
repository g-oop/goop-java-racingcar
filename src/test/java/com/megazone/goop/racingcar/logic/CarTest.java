package com.megazone.goop.racingcar.logic;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    RandomGenerator randomGenerator;
    Car car;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
        car = new Car();
    }

    @DisplayName("매번 0~9 사이의 랜덤값을 구한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void randomBetweenTest(int value) {
        int bound = 10;

        assertThat(randomGenerator.getRandomValue(bound)).isGreaterThanOrEqualTo(0);

        assertThat(randomGenerator.getRandomValue(bound)).isLessThanOrEqualTo(9);
    }

    @DisplayName("자동차는 랜덤값이 4 이상인 경우에 1 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveByOneIfValueFourOrMoreTest(int randValue) {
        assertThat(car.move(randValue)).isEqualTo(1);
    }

    @DisplayName("자동차는 랜덤값이 4 미만인 경우에 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveIfValueFourOrMoreTest(int randValue) {
        assertThat(car.move(randValue)).isEqualTo(0);
    }
}
