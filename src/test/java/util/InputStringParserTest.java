package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InputStringParserTest {

    @DisplayName("1단계 > String 클래스 > 요구사항 1")
    @ParameterizedTest
    @MethodSource("basicSource")
    void basic(BasicSource source) {
        String[] result = InputStringParser.splitInput(source.input());
        assertThat(result).containsExactly(source.expected());
    }

    private static Stream<Arguments> basicSource() {
        return Stream.of(
            Arguments.of(new BasicSource("1,2", new String[] {"1", "2"})),
            Arguments.of(new BasicSource("1", new String[] {"1"}))
        );
    }

    record BasicSource(String input, String[] expected) { }

}