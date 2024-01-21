package com.megazone.goop.racingcar.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @DisplayName("0~9 사이의 랜덤값을 구한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void randomBetweenTest(int value) {
        int bound = 10;

        assertThat(randomGenerator.getRandomValue(bound)).isGreaterThanOrEqualTo(0);

        assertThat(randomGenerator.getRandomValue(bound)).isLessThanOrEqualTo(9);
    }

}
