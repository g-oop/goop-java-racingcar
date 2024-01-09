package racingcar;

import java.util.Arrays;
import java.util.List;

public class StringAddCalculator {

    private String inputString;

    public StringAddCalculator(String inputString) {
        this.inputString = inputString;
    }

    public int add() {
        return inputString == null ? 0 : Arrays.stream(inputString.split("[,:]"))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
