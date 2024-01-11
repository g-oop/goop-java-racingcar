package com.ppojin.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {

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
    @DisplayName("1) Set#size 검증")
    void size() {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource(value={"1", "2", "3"})
    @DisplayName("2) Set#contains 검증")
    void contains(int test) {
        assertThat(numbers).contains(test);
    }

    @ParameterizedTest
    @CsvSource(value={"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("3) Set#contains 검증")
    void contains_tf(int test, boolean expect) {
        assertThat(numbers.contains(test)).isEqualTo(expect);
    }
}
