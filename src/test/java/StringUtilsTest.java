import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringUtilsTest {

    @ParameterizedTest(name = "splitByComma: 배열로 변환 {0} -> {1}")
    @MethodSource("splitByCommaTestSource")
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
    @DisplayName("removeBracket: 괄호 제거")
    void removeBracketTest() {
        String test = "(1,2)";
        String expect = "1,2";
        String actual = StringUtils.removeBracket(test);
        System.out.println(">>>" + actual);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    @DisplayName("charAt: 대상 문자열")
    void charAtTest(int test, char expect) {
        String testStr = "abc";
        char actual = StringUtils.charAt(testStr, test);
        Assertions.assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"3"})
    @DisplayName("charAt: 에러 메세지 테스트")
    void charAtTest_ExceptionWhenOOB(int test) {
        String testStr = "abc";
        Assertions
                .assertThatThrownBy(() -> StringUtils.charAt(testStr, test))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("Index: %d, Size: %d", testStr.length(), test));
    }
}
