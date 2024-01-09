package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @DisplayName("구분자를 기준으로 분리한 각 숫자의 합 계산")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    @ParameterizedTest
    void executeSplitAndSum(String inputString, int result) {

        StringAddCalculator calculator = new StringAddCalculator(inputString);
        Assertions.assertThat(calculator.add()).isEqualTo(result);
    }

    @DisplayName("커스텀 구분자를 사용할 수 있도록 구현")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6", "//;\\n1;2;3|6"}, delimiter = '|')
    @ParameterizedTest
    void applyCustomerSplit(String inputString, int result) {

        StringAddCalculator calculator = new StringAddCalculator(inputString);
        Assertions.assertThat(calculator.add()).isEqualTo(result);
    }

    @DisplayName("숫자 이외의 값 또는 음수일 경우 Exception 발생")
    @ValueSource(strings = {"a", "-1", "//|\\n1|s|3",  "//;\\n1;-2;3"})
    @ParameterizedTest
    void throwInvalidValue(String inputString) {

        StringAddCalculator calculator = new StringAddCalculator(inputString);
        Assertions.assertThatThrownBy(calculator::add).isInstanceOf(RuntimeException.class);
    }
}