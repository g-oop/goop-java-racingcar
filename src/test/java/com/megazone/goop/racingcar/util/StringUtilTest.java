package com.megazone.goop.racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringUtilTest {

    private static final String TOKEN = ",";

    @Test
    void parseStringTest() {
        assertThat("1,2".split(TOKEN)).containsExactly("1", "2");
        assertThat("1".split(TOKEN)).containsExactly("1").hasSize(1);
    }

    @Test
    void getRangeStringTest() {
        String source = "(1,2)";
        String expected = "1,2";

        int lbIndex = source.indexOf("(");
        int rbIndex = source.indexOf(")");
        int start = lbIndex == -1 ? 0 : lbIndex + 1;
        int end = rbIndex == -1 ? source.length() : rbIndex;

        assertThat(source.substring(start, end)).isEqualTo(expected);
    }

    @DisplayName("catch an exception that occurs when an out-of-range character is retrieved.")
    @Test
    void getCharAtTest() {
        int index = 5;

        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
                "abc".charAt(index);
            })
            .withMessage("String index out of range: %s", index)
            .withMessageContaining("index out of range")
            .withNoCause();
    }
}
