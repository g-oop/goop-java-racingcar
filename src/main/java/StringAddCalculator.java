import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER = 1;
    private static final int SPLIT_TARGET = 2;

    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        if (hasSingle(text)) {
            return parseInt(text);
        }

        return sum(split(text));
    }

    private static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        if (text.isBlank()) {
            return true;
        }
        return false;
    }

    private static boolean hasSingle(String text) {
        if (text.length() == 1) {
            return true;
        }
        return false;
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::parseInt).sum();
    }

    private static int parseInt(String text) {
        try {
            return Integer.parseUnsignedInt(text);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static String[] split(String text) {
        Matcher match = CUSTOM_DELIMITER_PATTERN.matcher(text);

        if (match.find()) {
            return match.group(SPLIT_TARGET).split(match.group(CUSTOM_DELIMITER));
        }
        return text.split(DEFAULT_DELIMITER);
    }

}
