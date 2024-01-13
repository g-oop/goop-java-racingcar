import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculator {

    @DisplayName("문자열 나눈뒤 합을 구함")
    public static int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(;)\n(.*)").matcher(inputString);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(delimiter);
            return StringSplitAndSum(tokens);
        }
        return returnsNumber(inputString);
    }
    @DisplayName("returnsNumberOrSumNumber호출 메서드")
    private static int returnsNumber(String inputString){

        return returnsNumberOrSumNumber(inputString);
    }

    @DisplayName("하나의 값을 리턴하거나 SumNumber를 리턴하는지 구함")
    private static int returnsNumberOrSumNumber(String inputString){
        String[] splitNumbers = inputString.split(",|:");
        return StringSplitAndSum(splitNumbers);
    }

    @DisplayName("문자열 나눈뒤 Sum 실행")
    private static int StringSplitAndSum(String[] splitNumbers) {
        int result = 0;
        for(String number: splitNumbers){
            validateNegativeNumber(Integer.parseInt(number));
            result += Integer.parseInt(number);
        }
        return result;
    }

    @DisplayName("음수일떄 Runtime 에러 실행")
    private static void validateNegativeNumber(int number) {
        if(number < 0){
            throw new RuntimeException("음수값이 들어갈수없습니다.");
        }
    }
}
