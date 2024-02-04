package com.megazone.goop.racingcar.util;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSetTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void getSizeTest() {
        System.out.printf("current size is %d %n", numbers.size());
    }

    @DisplayName("check whether it contains multiple values at once.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContainsTest(int param) {
        assertThat(numbers).contains(param);
    }

    @DisplayName("check whether it contains multiple values at once.")
    @ParameterizedTest
    @CsvSource(value = {"1?true", "2?true", "3?true", "4?false", "5?false"}, delimiter = '?')
    void isContainsMatchTest(int param, boolean expected) {
        assertThat(numbers.contains(param)).isEqualTo(expected);
    }
}
