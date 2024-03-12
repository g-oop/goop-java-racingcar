package racingcar.step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racingcar.step2.StringAddCalculator;

class StringAddCalculatorTest {

    @DisplayName("구분자를 기준으로 분리한 각 숫자의 합 계산")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    @ParameterizedTest
    void executeSplitAndSum(String inputString, int result) {
        Assertions.assertThat(StringAddCalculator.splitAndSum(inputString)).isEqualTo(result);
    }

    @DisplayName("공백이나 null이 입력 시 0 값 출력")
    @NullAndEmptySource
    @ParameterizedTest
    void executeSplitAndSumByEmpty(String inputString) {
        Assertions.assertThat(StringAddCalculator.splitAndSum(inputString)).isEqualTo(0);
    }

    @DisplayName("커스텀 구분자를 사용할 수 있도록 구현")
    @CsvSource(value = {"//s;s\\n1s;s2s;s3|6"}, delimiter = '|')
    @ParameterizedTest
    void applyCustomerSplit(String inputString, int result) {
        Assertions.assertThat(StringAddCalculator.splitAndSum(inputString))
            .isEqualTo(result);
    }

    @DisplayName("숫자 이외의 값 또는 음수일 경우 Exception 발생")
    @ValueSource(strings = {"a", "-1", "//|\\n1|s|3",  "//;\\n1;-2;3"})
    @ParameterizedTest
    void throwExceptions(String inputString) {
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum(inputString))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 이외의 값일 경우 Exception 발생")
    @Test
    void throwExceptionWhenInvalid() {

        String inputString = "test";

        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum(inputString))
            .withMessageMatching("숫자가 아닌 값이 입력되었습니다.");
    }

    @DisplayName("음수일 경우 Exception 발생")
    @Test
    void throwExceptionWhenNegative() {

        String inputString = "-1";

        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum(inputString))
            .withMessageMatching("음수는 입력될 수 없습니다.");
    }
}