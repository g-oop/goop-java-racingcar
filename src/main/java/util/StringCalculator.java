package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String[] DEFAULT_DELIMITERS = {",", ":"};
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.+)\\\\n(.+)");

    private StringCalculator() { }

    public static int add(String numbersString) {
        if (numbersString == null || numbersString.isBlank()) {
            return 0;
        }

        Integer oneNumber = parseIntIfJustOneNumber(numbersString);
        if (oneNumber != null) {
            return oneNumber;
        }

        StringAndDelimiters stringAndDelimiters = seperateRealNumbersStringAndDelimiters(numbersString);
        return splitAndSum(stringAndDelimiters.numbersString(), stringAndDelimiters.delimiters());
    }

    private record StringAndDelimiters(String numbersString, String[] delimiters) { }

    private static Integer parseIntIfJustOneNumber(String numbersString) {
        try {
            int number = Integer.parseInt(numbersString);
            validateAllowedRange(number);
            return number;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static void validateAllowedRange(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 처리할 수 없습니다.");
        }
    }

    private static StringAndDelimiters seperateRealNumbersStringAndDelimiters(String numbersString) {
        boolean startsWithCustomDelimiter = numbersString.startsWith(CUSTOM_DELIMITER_START);
        if (startsWithCustomDelimiter) { //약간의 성능 향상
            Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(numbersString);
            if (matcher.find() && matcher.groupCount() == 2) {
                return new StringAndDelimiters(matcher.group(2), new String[] {matcher.group(1)});
            }
        }
        return new StringAndDelimiters(numbersString, DEFAULT_DELIMITERS);
    }

    private static int splitAndSum(String numbersString, String[] delimiters) {
        return splitAndSum(numbersString, delimiters, 0);
    }

    private static int splitAndSum(String numbersString, String[] delimiters, int delimiterIndex) {
        String[] splitNumbersString = splitByDelimiter(numbersString, delimiters[delimiterIndex]);
        int sum = 0;
        for (String numberStr: splitNumbersString) {
            Integer oneNumber = parseIntIfJustOneNumber(numberStr);
            if (oneNumber != null) {
                sum += oneNumber;
                continue;
            }

            int nextDelimiterIndex = delimiterIndex + 1;
            validateIfCanSplitContinuously(delimiters, nextDelimiterIndex);
            sum += splitAndSum(numberStr, delimiters, nextDelimiterIndex); //재귀 호출
        }
        return sum;
    }

    private static String[] splitByDelimiter(String numbersString, String delimiter) {
        //return numbersString.split(delimiter); //구분자가 정규표현식에 사용되는 문자인 경우 오류 발생. 예를 들어 구분자가 .인 경우
        List<String> result = new ArrayList<>();
        doSplitByDelimiter(numbersString, delimiter, result);
        return result.toArray(String[]::new);
    }

    private static void doSplitByDelimiter(String numbersString, String delimiter, List<String> result) {
        int firstDelimiterIndex = numbersString.indexOf(delimiter);
        if (firstDelimiterIndex == -1) {
            if (!numbersString.isBlank()) {
                result.add(numbersString);
            }
            return;
        }

        String numberStr = numbersString.substring(0, firstDelimiterIndex);
        result.add(numberStr);

        String remainNumbersString = numbersString.substring(firstDelimiterIndex + delimiter.length());
        doSplitByDelimiter(remainNumbersString, delimiter, result); //재귀 호출
    }

    private static void validateIfCanSplitContinuously(String[] delimiters, int delimiterIndex) {
        if (delimiters.length <= delimiterIndex) {
            throw new RuntimeException("숫자로 변환할 수 없습니다.");
        }
    }
}
