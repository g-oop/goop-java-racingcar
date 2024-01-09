package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAddCalculatorTest {

    @DisplayName("구분자를 기준으로 분리한 각 숫자의 합 계산")
    @CsvSource(value = {"|0", "1,2|3", "1,2,3|6", "1,2:3|6"}, delimiter = '|')
    @ParameterizedTest
    void executeSplitAndSum(String inputString, int result) {

        StringAddCalculator calculator = new StringAddCalculator(inputString);
        Assertions.assertThat(calculator.add()).isEqualTo(result);
    }
}