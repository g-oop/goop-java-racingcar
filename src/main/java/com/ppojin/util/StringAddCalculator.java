package com.ppojin.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String delimiter = ",|:";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (StringUtils.isEmpty(text)) {
            return 0;
        }

        String postDelimiter = getDelimiter(text);

        text = delimiter.equals(postDelimiter) ? text : text.substring(4);

        String[] strings = StringUtils.splitByDelimiter(text, postDelimiter);

        return Arrays.stream(strings)
                .map(s -> {
                    int n = Integer.parseInt(s);
                    if (n < 0) {
                        throw new RuntimeException("요소에 음수는 입력할 수 없습니다.");
                    }
                    return n;
                })
                .mapToInt(i -> i)
                .sum();
    }

    private static String getDelimiter(String text) {
        Matcher m = Pattern.compile("^//(.)\n(.*)$").matcher(text);
        if(m.find()){
            return delimiter + "|" + m.group(1);
        }
        return delimiter;
    }
}
