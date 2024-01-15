import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.*)\n(.*)");
    private static final String NUMBERS_REGEX = "^[0-9]*$";
    private static final String REGEX = "[,|:]";

    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(inputString);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(delimiter);
            return splitAndSumStrings(tokens);
        }
        return splitAndSumStrings(inputString.split(REGEX));
    }

    private static int splitAndSumStrings(String[] splitNumbers) {
        int result = 0;
        for(String number: splitNumbers){
            int returnNonNegative = validateAndReturnNonNegative(number);
            result += returnNonNegative;
        }
        return result;
    }

    private static int validateAndReturnNonNegative(String number) {
        if(!number.matches(NUMBERS_REGEX)){
            throw new RuntimeException("음수값이 들어갈수없습니다.");
        }
        return Integer.parseInt(number);
    }
}
