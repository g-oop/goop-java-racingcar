package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String DELIMITER_SEPARATOR = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        if (isInteger(text)) {
            return stringToInt(text);
        }
        Matcher matcher = Pattern.compile(DELIMITER_SEPARATOR).matcher(text);
        if (matcher.find()) {
            return getDelimiterSum(matcher);
        }
        return splitBySeparator(text);
    }

    private static boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private static int stringToInt(String text) {
        return Integer.parseInt(text);
    }

    private static int getDelimiterSum(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        return getSum(tokens);
    }

    private static int splitBySeparator(String text) {
        String[] tokens = text.split(SEPARATOR);
        return getSum(tokens);
    }

    private static int getSum(String[] tokens) {
        return Arrays.stream(tokens)
            .mapToInt(Integer::parseInt)
            .map(StringAddCalculator::validateNegative)
            .sum();
    }

    private static int validateNegative(int i) {
        if (Integer.signum(i) == -1) {
            throw new RuntimeException();
        }
        return i;
    }

}
