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

        if (inputString == null) return 0;

        int sum = 0;
        for (String s : inputString.split(delimiter == null ? "[,:]" : delimiter)) {
            try {
                int i = Integer.parseInt(s);
                if (i < 0) throw new RuntimeException();
                sum += i;
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }

        return sum;
    }
}
