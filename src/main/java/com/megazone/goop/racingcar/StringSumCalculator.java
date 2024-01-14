package com.megazone.goop.racingcar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.megazone.goop.racingcar.exception.NotAllowedNumberException;

public class StringSumCalculator {

    private static final String DEFAULT_DELIMITERS = "[,|:]";

    public String[] split(String text) {
        if (text == null) {
            return new String[] {};
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(DEFAULT_DELIMITERS.replace("]", "|" + m.group(1) + "]"));
        }

        return text.split(DEFAULT_DELIMITERS);
    }

    public int sum(String[] numbers) throws NumberFormatException, NotAllowedNumberException {
        int sum = 0;

        for (String number: numbers) {
            if (!number.isEmpty()) {
                int add = Integer.parseInt(number);의

                if (add < 0) {
                    throw new NotAllowedNumberException("Negative numbers are not allowed.");
                }
                sum += add;
            }
        }
        return sum;
    }
}
