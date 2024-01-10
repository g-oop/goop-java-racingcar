package com.ppojin.util;

public class StringUtils {

    private StringUtils() {
    }

    public static String[] splitByComma(String t){
        return t.split(",");
    }

    public static String removeBracket(String t){
        if (charAt(t, 0) == '(' && charAt(t, t.length()-1) == ')') {
            return t.substring(1, t.length()-1);
        }
        return t;
    }

    public static char charAt(String t, int i){
        if(t.length() <= i) {
            throw new IndexOutOfBoundsException(){
                @Override
                public String getMessage() {
                    return String.format("Index: %d, Size: %d", t.length(), i);
                }
            };
        }
        return t.charAt(i);
    }

    public static boolean isEmpty(String num) {
        return num == null || num.isEmpty();
    }
}
