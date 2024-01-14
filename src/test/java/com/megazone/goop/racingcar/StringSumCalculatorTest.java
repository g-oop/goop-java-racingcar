package com.megazone.goop.racingcar;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringSumCalculatorTest {

    private static StringSumCalculator calc;

    @BeforeAll
    static void initTest() {
        calc = new StringSumCalculator();
    }

    @Test
    @DisplayName("Null or empty string sum")
    void splitAndSumNullTest() throws Exception {
        int sumOfNull = calc.splitAndSum(null);
        assertThat(sumOfNull).isZero();

        int sumOfEmpty = calc.splitAndSum("");
        assertThat(sumOfEmpty).isZero();
    }

    @Test
    @DisplayName("Only one number string sum")
    void splitAndSumOneTest() throws Exception {
        int sum = calc.splitAndSum("1");
        assertThat(sum).isEqualTo(1);
    }

    @Test
    @DisplayName("Parse numbers string by default delimiter")
    void splitAndSumCommaTest() throws Exception {
        int sum = calc.splitAndSum("1,2");
        assertThat(sum).isEqualTo(3);

        sum = calc.splitAndSum("1,,,,2");
        assertThat(sum).isEqualTo(3);
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
        int sum = calc.splitAndSum("//;\n1;2;3,4:5");
        assertThat(sum).isEqualTo(15);
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
