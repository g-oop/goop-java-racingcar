package step1.racingcar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitUtils {

    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern PATTERN = Pattern.compile(CUSTOM_DELIMITER);

    public static String[] splitBySeparator(String text) {
        String delimiter = "";
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            text = matcher.group(2);
        }
        return splitByDelimiter(text, delimiter);
    }

    private static String[] splitByDelimiter(String text, String delimiter) {
        return text.split(delimiter);
    }

}
