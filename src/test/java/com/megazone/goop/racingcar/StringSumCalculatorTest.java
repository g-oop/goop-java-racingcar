package com.megazone.goop.racingcar;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSumCalculatorTest {

    private static StringSumCalculator calc;

    @BeforeAll
    static void initTest() {
        calc = new StringSumCalculator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null or empty string sum")
    void splitAndSumNullTest(String text) throws Exception {
        int sumOfEmpty = calc.splitAndSum(text);
        assertThat(sumOfEmpty).isZero();
    }

    @Test
    @DisplayName("Only one number string sum")
    void splitAndSumOneTest() throws Exception {
        int sum = calc.splitAndSum("1");
        assertThat(sum).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "1,,,,2,4=7"}, delimiter = '=')
    @DisplayName("Parse numbers string by default delimiter")
    void splitAndSumCommaTest(String text, int result) throws Exception {
        int sum = calc.splitAndSum(text);
        assertThat(sum).isEqualTo(result);
    }

    @Test
    @DisplayName("Parse numbers string by default delimiters")
    void splitAndSumCommaColonTest() throws Exception {
        int sum = calc.splitAndSum("1,2:3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("Parse number strings by custom delimiter")
    void splitAndSumCustomDelimTest() throws Exception {
        int sum = calc.splitAndSum("//;\n1;2;3");
        assertThat(sum).isEqualTo(6);
    }

    @Test
    @DisplayName("Parse number strings containing negative number")
    void splitAndSumNegativeTest() throws Exception {
        assertThatThrownBy(() ->
            calc.splitAndSum("1,-2,3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Parse numbers string containing non-numeric")
    void splitAndSumNoNumberTest() throws Exception {
        assertThatThrownBy(() ->
            calc.splitAndSum("1,2,N,3")
        ).isInstanceOf(RuntimeException.class);
    }
}
