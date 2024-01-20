package stringcaculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import stringcalculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void calculateBlank(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }

    @Test
    void calculateSingleNumber() {
        Integer result =  StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void calculateNumbersByComma() {
        Integer result =  StringAddCalculator.splitAndSum("1,2,3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void calculateNumbersByCommaAndColon() {
        Integer result =  StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void calculateNumbersByCustomDelimiter() throws Exception {
        int result =  StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void throwsExceptionWhenNegativeValuePassed() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
