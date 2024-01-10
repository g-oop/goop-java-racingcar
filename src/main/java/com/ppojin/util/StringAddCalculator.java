package com.ppojin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String numericStr) {
        if (StringUtils.isEmpty(numericStr)) {
            return 0;
        }

        return 1;
    }

    private static String getDelimiter(String text) {
        String delimiter = ",|:";
        Matcher m = Pattern.compile("^//(.)\n(.*)$").matcher(text);
        if(m.find()){
            return delimiter + "|" + m.group(1);
        }
        return delimiter;
    }
}
