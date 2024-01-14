package racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String inputString) {

        String delimiter = getDelimiter(inputString);

        String[] result = splitString(delimiter, inputString);

        return sumStrings(result);
    }

    private static Matcher getMatcher(String inputString) {
        return Pattern.compile("\\/\\/(.+)\\\\n(.+)").matcher(inputString);
    }

    private static String getDelimiter(String inputString) {

        String delimiter = "[,:]";

        if (inputString != null && !inputString.isEmpty()) {

            Matcher matcher = getMatcher(inputString);
            if (matcher.find()) delimiter = matcher.group(1);
        }

        return delimiter;
    }

    private static String[] splitString(String delimiter, String inputString) {

        String[] result = new String[0];

        if (inputString != null && !inputString.isEmpty()) {

            Matcher matcher = getMatcher(inputString);
            if (matcher.find()) {
                result = matcher.group(2).split(delimiter);
            } else {
                result = inputString.split(delimiter);
            }
        }

        return result;
    }

    private static int parseInt(String s) {

        int i;

        try {
            i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자가 아닌 값이 입력되었습니다.");
        }

        if (i < 0) throw new RuntimeException("음수는 입력될 수 없습니다.");

        return i;
    }

    private static int sumStrings(String[] inputStrings) {

        if (inputStrings.length == 0) return 0;

        int sum = 0;
        for (String s : inputStrings) {
            sum += parseInt(s);
        }

        return sum;
    }
}
