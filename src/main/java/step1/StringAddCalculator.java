package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR);

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            return getSum(splitByCustomSeparator(matcher));
        }
        return getSum(splitBySeparator(text));
    }

    private static String[] splitByCustomSeparator(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        return matcher.group(2).split(customDelimiter);
    }

    private static String[] splitBySeparator(String text) {
        return text.split(SEPARATOR);
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens)
            .mapToInt(StringAddCalculator::toInt)
            .sum();
    }

    private static int toInt(String text) {
        int number = Integer.parseInt(text);
        validateNegative(number);
        return number;
    }

    private static void validateNegative(int number) {
        if (Integer.signum(number) == -1) {
            throw new RuntimeException();
        }
    }

}
