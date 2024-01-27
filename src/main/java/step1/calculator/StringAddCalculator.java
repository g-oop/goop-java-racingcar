package step1.calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_SEPARATOR);

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String delimiter = SEPARATOR;
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }
        String[] textArr = splitByDelimiter(text, delimiter);
        return sum(toIntStream(textArr));
    }

    private static String[] splitByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }

    private static IntStream toIntStream(String[] tokens) {
        return Arrays.stream(tokens)
            .mapToInt(StringAddCalculator::toInt);
    }

    private static int sum(IntStream intStream) {
        return intStream.sum();
    }

    private static int toInt(String text) {
        try {
            int number = Integer.parseInt(text);
            validateNegative(number);
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    private static void validateNegative(int number) {
        if (Integer.signum(number) == -1) {
            throw new RuntimeException();
        }
    }

}
