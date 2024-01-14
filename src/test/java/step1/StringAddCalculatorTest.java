package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈 문자열이면 0 리턴")
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1=1", "5=5", "100=100"}, delimiter = '=')
    @DisplayName("숫자 하나면 숫자 리턴")
    public void splitAndSum_숫자하나(String input, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "5,5,5=15"}, delimiter = '=')
    @DisplayName("쉼표 구분자로 구분하고 합 구하기")
    public void splitAndSum_쉼표구분자(String input, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "1:2,3=6"}, delimiter = '=')
    @DisplayName("쉼표 또는 콜론 구분자로 구분하고 합 구하기")
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분하고 합 구하기")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1,2,3"})
    @DisplayName("쉼표로 구분하고 음수인 경우 예외 발생")
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
            .isInstanceOf(RuntimeException.class);
    }

}
