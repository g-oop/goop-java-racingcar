package com.megazone.goop.racingcar.logic;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    RandomGenerator randomGenerator;

    @BeforeEach
    void setUp() {
        randomGenerator = new RandomGenerator();
    }

    @DisplayName("0~9 사이의 랜덤값을 구한다.")
    @Test
    void randomBetweenTest() {
        int bound = 10;

        for (int i = 0; i < 100000; i++) {
            assertThat(randomGenerator.getRandomValue(bound))
                .isNotNegative()
                .isLessThanOrEqualTo(bound - 1);
        }
    }
}
