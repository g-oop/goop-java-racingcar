package racingcar.stringcaculator;

import org.junit.jupiter.api.*;
import racingcar.stringcalculator.StringAddCalculator;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    void calculateBlank() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result =  StringAddCalculator.splitAndSum("");
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
}
