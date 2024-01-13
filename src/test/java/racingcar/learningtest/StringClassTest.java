package racingcar.learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringClassTest {

    @Test
    @DisplayName("요구사항 1 > split 테스트(1)")
    void splitStringByComma() {
        // given
        String input = "1,2";

        // when
        String[] output = input.split(",");

        // then
        String[] expected = {"1", "2"};
        assertThat(expected).containsExactly(output);
    }

    @Test
    @DisplayName("요구사항 1 > split 테스트(2)")
    void splitStringWithOneElement() {
        // given
        String input = "1";

        // when
        String[] output = input.split(",");

        // then
        String[] expected = {"1"};
        assertThat(expected).containsExactly(output);

    }

    @Test
    @DisplayName("요구사항 2 > substring 테스트")
    void substringTest() {
        // given
        String enclosedString = "(1,2)";

        // when
        int startIdx = enclosedString.indexOf("(") + 1;
        int endIdx = enclosedString.indexOf(")");
        String unenclosedString = enclosedString.substring(startIdx, endIdx);

        // then
        String expected = "1,2";
        assertEquals(expected, unenclosedString);
    }

    @Test
    @DisplayName("요구사항 3 > whenExceptionThrown_thenSuccess")
    void getCharIndexTest() {
        // given
        String input = "abc";

        // when & then
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> {
                int inputLength = input.length();
                int invalidIndex = inputLength + 1;

                try {
                    input.charAt(invalidIndex);
                } catch (StringIndexOutOfBoundsException e){
                    String message = String.format("Index: %d, Size: %d",invalidIndex, inputLength );
                    throw  new StringIndexOutOfBoundsException(message);
                }

            }).withMessageMatching("Index: \\d+, Size: \\d+");
    }
}
