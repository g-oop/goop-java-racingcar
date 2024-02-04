package com.megazone.goop.racingcar.util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    private static final String DEFAULT_DELIMITERS_REGEX = "[,|:]";

    private static final Pattern  CUSTOM_DELIMITERS_REGEX_PATTERN = Pattern.compile("^//(.)\n(.*)$");

    public int splitAndSum(String text) {
        return Arrays.stream(split(text))
            .filter(n -> !n.isEmpty())
            .mapToInt(Integer::parseInt)
            .map(n -> {
                if (n < 0) {
                    throw new RuntimeException("Negative numbers are not allowed.");
                }
                return n;
            }).sum();
    }

    private String[] split(String text) {
        if (text == null) {
            return new String[] {};
        }

        String delimiters = DEFAULT_DELIMITERS_REGEX;
        String realText = text;

        Matcher m = CUSTOM_DELIMITERS_REGEX_PATTERN.matcher(text);
        if (m.find()) {
            delimiters = addCustomDelimiter(m.group(1));
            realText = m.group(2);
        }

        return realText.split(delimiters);
    }

    private static String addCustomDelimiter(String customDelimiter) {
        return DEFAULT_DELIMITERS_REGEX.replace("]", "|" + customDelimiter + "]");
    }

}
