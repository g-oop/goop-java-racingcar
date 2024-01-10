import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class StringUtilsTest {

    @ParameterizedTest(name = "( \"{0}\" ) -> {1}")
    @MethodSource("splitByCommaTestSource")
    @DisplayName("1) splitByComma: 배열로 변환")
    void splitByCommaTest(String test, String[] expect) {
        String[] result = StringUtils.splitByComma(test);
        Stream.of(expect).forEach(Assertions.assertThat(result)::contains);
        Assertions.assertThat(result).containsExactly(expect);
    }

    static Stream<Arguments> splitByCommaTestSource() {
        return Stream.of(
                Arguments.arguments("1,2", new String[]{"1", "2"}),
                Arguments.arguments("1", new String[]{"1"})
        );
    }

    @Test
    @DisplayName("2) removeBracket: 괄호 제거")
    void removeBracketTest() {
        String test = "(1,2)";
        String expect = "1,2";
        String actual = StringUtils.removeBracket(test);
        System.out.println(">>>" + actual);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("2) removeBracket: 괄호 제거 안함")
    void removeBracketTest_() {
        String test = "1,2";
        String expect = "1,2";
        String actual = StringUtils.removeBracket(test);
        System.out.println(">>>" + actual);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest(name = "( \"abc\", {0} ) -> {1}")
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    @DisplayName("3) charAt: \"abc\" 에서 대상 문자")
    void charAtTest(int test, char expect) {
        String testStr = "abc";
        char actual = StringUtils.charAt(testStr, test);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"3", "4"})
    @DisplayName("3) charAt: 에러 메세지 테스트")
    void charAtTest_ExceptionWhenOOB(int testIdx) {
        String testStr = "abc";
        String errorMessageExcept = String.format("Index: %d, Size: %d", testStr.length(), testIdx);
        System.out.println(">>> errorMessageExcept: " + errorMessageExcept);
        Assertions
                .assertThatThrownBy(() -> StringUtils.charAt(testStr, testIdx))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(errorMessageExcept);
    }
}
