package com.ppojin.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_CONVENTION = "^//(.)\n(.*)$";
    private static final int CUSTOM_DELIMITER_CONVENTION_END_INDEX = 4;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        final String delimiter = getDelimiter(text);

        if (!DELIMITER.equals(delimiter)) {
            text = text.substring(CUSTOM_DELIMITER_CONVENTION_END_INDEX);
        }

        final String[] nums = StringUtils.splitByDelimiter(text, delimiter);

        return Arrays.stream(nums)
                .map(StringAddCalculator::parseIntExceptNegative)
                .mapToInt(i -> i)
                .sum();
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_CONVENTION).matcher(text);
        if(m.find()){
            return DELIMITER + "|" + m.group(1);
        }
        return DELIMITER;
    }

    private static int parseIntExceptNegative(String s) {
        int n = Integer.parseInt(s);
        if (n < 0) {
            throw new IllegalArgumentException("요소에 음수는 입력할 수 없습니다.");
        }
        return n;
    }
}
