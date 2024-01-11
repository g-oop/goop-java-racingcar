package racingcar;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @DisplayName("구분자를 기준으로 분리한 각 숫자의 합 계산")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    @ParameterizedTest
    void executeSplitAndSum(String inputString, int result) {

        StringAddCalculator calculator = new StringAddCalculator();
        Map<String, String> resultMap = calculator.parse(inputString);
        Assertions.assertThat(calculator.splitAndSum(resultMap.get("delimiter"), resultMap.get("inputString"))).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 사용할 수 있도록 구현")
    @CsvSource(value = {"//s;s\\n1s;s2s;s3|6"}, delimiter = '|')
    @ParameterizedTest
    void applyCustomerSplit(String inputString, int result) {

        StringAddCalculator calculator = new StringAddCalculator();
        Map<String, String> resultMap = calculator.parse(inputString);
        Assertions.assertThat(calculator.splitAndSum(resultMap.get("delimiter"), resultMap.get("inputString")))
            .isEqualTo(result);
    }

    @DisplayName("숫자 이외의 값 또는 음수일 경우 Exception 발생")
    @ValueSource(strings = {"a", "-1", "//|\\n1|s|3",  "//;\\n1;-2;3"})
    @ParameterizedTest
    void throwExceptions(String inputString) {

        StringAddCalculator calculator = new StringAddCalculator();
        Map<String, String> resultMap = calculator.parse(inputString);
        Assertions.assertThatThrownBy(() -> calculator.splitAndSum(resultMap.get("delimiter"), resultMap.get("inputString")))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자 이외의 값일 경우 Exception 발생")
    @Test
    void throwExceptionWhenInvalid() {

        StringAddCalculator calculator = new StringAddCalculator();
        Map<String, String> resultMap = calculator.parse("test");
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.splitAndSum(resultMap.get("delimiter"), resultMap.get("inputString")))
            .withMessageMatching("숫자가 아닌 값이 입력되었습니다.");
    }

    @DisplayName("음수일 경우 Exception 발생")
    @Test
    void throwExceptionWhenNegative() {

        StringAddCalculator calculator = new StringAddCalculator();
        Map<String, String> resultMap = calculator.parse("-1");
        Assertions.assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> calculator.splitAndSum(resultMap.get("delimiter"), resultMap.get("inputString")))
            .withMessageMatching("음수는 입력될 수 없습니다.");
    }
}