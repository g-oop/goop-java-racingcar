package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private String delimiter;
    private String inputString;

    public StringAddCalculator(String inputString) {

        if (inputString != null) {

            Matcher matcher = Pattern.compile("\\/\\/(.)\\\\n(.+)").matcher(inputString);
            if (matcher.find()) {
                this.delimiter = matcher.group(1);
                inputString = matcher.group(2);
            }

            this.inputString = inputString;
        }
    }

    public int add() {
        return inputString == null ? 0 : Arrays.stream(inputString.split(delimiter == null ? "[,:]" : delimiter))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
