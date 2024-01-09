package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

class InputStringParserTest {

    @DisplayName("1단계 > String 클래스 > 요구사항 1, 2")
    @ParameterizedTest
    @MethodSource("basicSource")
    void basic(BasicSource source) {
        String[] result = InputStringParser.splitInput(source.input());
        assertThat(result).containsExactly(source.expected());
    }

    private static Stream<Arguments> basicSource() {
        return Stream.of(
            Arguments.of(new BasicSource("1,2", "1", "2")),
            Arguments.of(new BasicSource("1", "1")),
            Arguments.of(new BasicSource("(1,2)", "1", "2")),
            Arguments.of(new BasicSource("(1)", "1"))
        );
    }

    record BasicSource(String input, String... expected) { }


    @DisplayName("1단계 > String 클래스 > 요구사항 3")
    @ParameterizedTest
    @CsvSource(value = {
        "abc,3",
        "wxyz,4"
    })
    void basic(String input, int index) {
        ThrowingCallable callable = () -> input.charAt(index);
        assertThatThrownBy(callable).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(callable);
    }

}