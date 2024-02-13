package learningtest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringClassTest {

    @Test
    @DisplayName("요구사항 1 > split 테스트(1)")
    void splitStringByComma() {
        String input = "1,2";

        String[] output = input.split(",");

        String[] expected = {"1", "2"};
        assertThat(output).containsExactly(expected);
    }

    @Test
    @DisplayName("요구사항 1 > split 테스트(2)")
    void splitStringWithOneElement() {
        String input = "1";

        String[] output = input.split(",");

        String[] expected = {"1"};
        assertThat(output).containsExactly(expected);

    }

    @Test
    @DisplayName("요구사항 2 > substring 테스트")
    void substringEnclosedText() {
        String enclosedString = "(1,2)";

        int startIdx = enclosedString.indexOf("(") + 1;
        int endIdx = enclosedString.indexOf(")");
        String unenclosedString = enclosedString.substring(startIdx, endIdx);

        String expected = "1,2";
        assertEquals(expected, unenclosedString);
    }

    @Test
    @DisplayName("요구사항 3 > whenExceptionThrown_thenSuccess")
    void throwsExceptionWhenIndexOutOfRange() {
        String input = "abc";
        int validIndex = 1;
        int invalidIndex = input.length() + 1;

        char output = input.charAt(validIndex);

        char expected = 'b';

        assertThat(output).isEqualTo(expected);

        assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(invalidIndex));
    }
}
