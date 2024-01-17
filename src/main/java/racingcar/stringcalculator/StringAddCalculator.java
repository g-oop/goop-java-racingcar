package racingcar.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static int splitAndSum(String text) {
        if (isBlank(text)){
            return 0;
        }

        return sum(tokenize(text));
    }

    private static boolean isBlank(String text) {
        if (text == null ){
            return true;
        }
        return text.isBlank();
    }

    private static String[] tokenize(String text){
        String delimiter = DEFAULT_DELIMITER;

        if (pattern.matcher(text).matches()){
            Matcher m = pattern.matcher(text);
            if (m.find()) {
                delimiter = m.group(1);
                text = m.group(2);
            }
        }
        return text.split(delimiter);
    }



    private static int parsePositiveNumber(String token){
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new RuntimeException("Only positive numbers are allowed");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Only Numbers are allowed");
        }
    }

    private static int sum(String[] tokens){
        return Arrays.stream(tokens)
            .mapToInt(StringAddCalculator::parsePositiveNumber)
            .sum();
    }










}
