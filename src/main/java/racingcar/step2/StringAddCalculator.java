package racingcar.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern PATTERN = Pattern.compile("\\/\\/(.+)\\\\n(.+)");

    public static int splitAndSum(String inputString) {

        if (inputString == null || inputString.isEmpty()) return 0;

        String delimiter = getDelimiter(inputString);

        String[] result = splitString(delimiter, inputString);

        return sumStrings(result);
    }

    private static Matcher getMatcher(String inputString) {
        return PATTERN.matcher(inputString);
    }

    private static String getDelimiter(String inputString) {

        String delimiter = "[,:]";

        Matcher matcher = getMatcher(inputString);
        if (matcher.find()) delimiter = matcher.group(1);

        return delimiter;
    }

    private static String[] splitString(String delimiter, String inputString) {

        Matcher matcher = getMatcher(inputString);
        if (matcher.find()) {
            inputString = matcher.group(2);
        }

        return inputString.split(delimiter);
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

        int sum = 0;
        for (String s : inputStrings) {
            sum += parseInt(s);
        }

        return sum;
    }
}
