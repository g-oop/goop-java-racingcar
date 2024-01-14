import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER = 1;
    private static final int SPLIT_TARGET = 2;
    private static final int ASCII_ZERO = 48;
    private static final int ASCII_NINE = 57;


    private StringAddCalculator() {}

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }

        if (hasSingle(text)) {
            return parseUnsignedInt(text);
        }

        return sum(split(text));
    }

    private static boolean isEmpty(String text) {
        return text == null||text.isBlank();
    }

    private static boolean hasSingle(String text) {
        return text.length() == 1;
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::parseUnsignedInt).sum();
    }

    private static int parseUnsignedInt(String text) {
        validationUnsignedInt(text);
        return Integer.parseUnsignedInt(text);
    }

    private static void validationUnsignedInt(String text) {
        validationMinusInt(text);
        validationInt(text);
    }

    private static void validationMinusInt(String text) {
        if (text.charAt(0) == '-') {
            throw new IllegalArgumentException(String.format("Illegal leading minus sign " +
                "on unsigned string %s.", text));
        }
    }

    private static void validationInt (String text) {
        char firstChar =  text.charAt(0);
        if(firstChar < ASCII_ZERO || firstChar > ASCII_NINE) {
            throw new IllegalArgumentException(String.format("Cannot parse not int value %s.", text));
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
