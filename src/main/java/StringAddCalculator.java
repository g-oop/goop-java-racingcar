import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";

    public static int splitAndSum(String text) {
        if (text == null) {
            return 0;
        }

        if (text.isEmpty()) {
            return 0;
        }

        if (text.length() == 1) {
            return parseInt(text);
        }

        return sum(split(text));
    }

    private static int parseInt(String text) {
        try {
            return Integer.parseUnsignedInt(text);
        }catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(StringAddCalculator::parseInt).sum();
    }
}
