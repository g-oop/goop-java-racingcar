package racingcar.stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isBlank(text)){
            return 0;
        }

        String[] tokens = tokenize(text);
        validate(tokens);

        return sum(tokens);
    }

    private static boolean isBlank(String text) {
        if (text == null ){
            return true;
        }
        return text.isBlank();
    }

    private static String[] tokenize(String text){
        if (text.matches(CUSTOM_DELIMITER_PATTERN)){
            Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(text);
            if (m.find()) {
                String customDelimiter = m.group(1);
                String numericText = m.group(2);
                return numericText.split(customDelimiter);
            }
        }
        return text.split(DEFAULT_DELIMITER);
    }

    private static void validate(String[] tokens){
        for (String token : tokens) {
            int number = parseIfNumeric(token);
            if (number < 0) {
                throw new RuntimeException("Only positive numbers are allowed");
            }
        }
    }

    private static int parseIfNumeric(String token){
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Only Numbers are allowed");
        }
    }

    private static int sum(String[] tokens){
        return Arrays.stream(convertToNumbers(tokens)).sum();
    }

    private static int[] convertToNumbers(String[] tokens) {
        int[] numbers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            numbers[i] = parseIfNumeric(tokens[i]);
        }

        return numbers;
    }









}
